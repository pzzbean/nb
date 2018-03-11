package com.ibase.core.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;






import com.alibaba.fastjson.JSONObject;
import com.ibase.core.security.Md5;
import com.ibase.core.utils.StringUtil;

/**
 * HTTP 请求
 * @author admin
 *
 */
public class HttpUtil {
	
	protected final static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	protected final static String MD5_KEY = "1234567890";
	
	public static int CONNCT_TIMEOUT = 60000;
    public static int READ_TIMEOUT = 60000;
    public static String CHARSET_UTF8 = "UTF-8";
    public static int ERROR = -1;
    
    
    public static String encodeBase64(String data) {
		return Base64.encodeBase64String(StringUtil.getUTF8Bytes(data));
	}

	public static String decodeBase64(String data) {
		return new String(Base64.decodeBase64(data));
	}
	
	public static String encodeURL(String data) {
		try {
			return URLEncoder.encode(data, "utf8");
		} catch (UnsupportedEncodingException e) {
			return data;
		}
	}

	public static String decodeURL(String data) {
		try {
			return URLDecoder.decode(data, "utf8");
		} catch (IOException e) {
			return data;
		}
	}

    /**
     * 提交文本数据
     * 
     * @param url 地址
     * @param header 请求头
     * @param body 内容
     * @return
     */
    public static HttpResponse post(String url, Map<String, String> header, String body) {
        if (isHttpsRequest(url)) {
            _ignoreSSL();
        }
        HttpURLConnection conn = null;
        OutputStream out = null;
        InputStreamReader streamReader = null;
        BufferedReader bufferedReader = null;
        URL requestUrl = null;
        try {
            requestUrl = new URL(url);
            conn = (HttpURLConnection) requestUrl.openConnection();
            if (header != null) {
                for (Iterator<String> it = header.keySet().iterator(); it.hasNext();) {
                    String key = it.next();
                    String value = header.get(key);
                    conn.setRequestProperty(key, value);
                }
            } else {
                //默认设置
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            }
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setConnectTimeout(CONNCT_TIMEOUT);
            conn.setReadTimeout(READ_TIMEOUT);

            out = conn.getOutputStream();
            out.write(body.getBytes(CHARSET_UTF8));
            out.flush();

            String line;
            StringBuilder sb = new StringBuilder();
            try {
                streamReader = new InputStreamReader(conn.getInputStream(), CHARSET_UTF8);
            } catch (IOException e) {
                streamReader = new InputStreamReader(conn.getErrorStream(), CHARSET_UTF8);
            } finally {
                if (streamReader != null) {
                    bufferedReader = new BufferedReader(streamReader);
                    sb = new StringBuilder();
                    while ((line = bufferedReader.readLine()) != null) {
                        sb.append(line);
                    }
                }
            }
            return new HttpResponse(conn.getResponseCode(), conn.getResponseMessage(), sb.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return new HttpResponse(ERROR, e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            return new HttpResponse(ERROR, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new HttpResponse(ERROR, e.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                }
            }
            if (streamReader != null) {
                try {
                    streamReader.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    /**
     * 提交表单数据
     * 
     * @param url 地址
     * @param header 请求头
     * @param params 参数
     * @return
     */
    public static HttpResponse postForm(String url, Map<String, String> header, Map<String, String> params) {
        return post(url, header, httpBuildQuery(params));
    }

    /**
     * 请求数据
     * 
     * @param url 地址
     * @param header 请求头
     * @param params 请求参数
     * @return
     */
    public static HttpResponse get(String url, Map<String, String> header, Map<String, String> params) {
        if (isHttpsRequest(url)) {
            _ignoreSSL();
        }
        HttpURLConnection conn = null;
        InputStreamReader streamReader = null;
        BufferedReader bufferedReader = null;
        URL requestUrl = null;
        try {
            if (params != null && !params.isEmpty()) {
                if (url.indexOf("?") > -1) {
                    url += httpBuildQuery(params);
                } else {
                    url += "?" + httpBuildQuery(params); 
                }
            }
            requestUrl = new URL(url);
            conn = (HttpURLConnection) requestUrl.openConnection();
            if (header != null) {
                for (Iterator<String> it = header.keySet().iterator(); it.hasNext();) {
                    String key = it.next();
                    String value = header.get(key);
                    conn.setRequestProperty(key, value);
                }
            }
            conn.setRequestMethod("GET");
            conn.setUseCaches(false);
            conn.setConnectTimeout(CONNCT_TIMEOUT);
            conn.setReadTimeout(READ_TIMEOUT);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            
            String line;
            StringBuilder sb = new StringBuilder();
            try {
                streamReader = new InputStreamReader(conn.getInputStream(), CHARSET_UTF8);
            } catch (IOException e) {
                e.printStackTrace();
                streamReader = new InputStreamReader(conn.getErrorStream(), CHARSET_UTF8);
            } finally {
                if (streamReader != null) {
                    bufferedReader = new BufferedReader(streamReader);
                    sb = new StringBuilder();
                    while ((line = bufferedReader.readLine()) != null) {
                        sb.append(line);
                    }
                }
            }
            return new HttpResponse(conn.getResponseCode(), conn.getResponseMessage(), sb.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return new HttpResponse(ERROR, e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            return new HttpResponse(ERROR, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new HttpResponse(ERROR, e.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                }
            }
            if (streamReader != null) {
                try {
                    streamReader.close();
                } catch (IOException e) {
                }
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    /**
     * 
     * @param url 请求地址
     * @param header 请求头
     * @return
     */
    public static HttpResponse get(String url, Map<String, String> header) {
        return get(url, header,null);
    }
    
    /**
     * 
     * @param url 请求地址
     * @return
     */
    public static HttpResponse get(String url) {
        return get(url, null,null);
    }
    
    public static boolean isHttpsRequest(String url) {
        if (url.startsWith("https")) {
            return true;
        }
        return false;
    }

    // ignoreSSL hostname verifer
    private static HostnameVerifier ignoreHostnameVerifier = new HostnameVerifier() {
        @Override
        public boolean verify(String s, SSLSession sslsession) {
            return true;
        }
    };

    /**
     * 忽略SSL
     */
    private static void _ignoreSSL() {
        try {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            } };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(ignoreHostnameVerifier);
        } catch (KeyManagementException ex) {
            logger.error(ex.getMessage());
        } catch (NoSuchAlgorithmException ex) {
        	 logger.error(ex.getMessage());
        }
    }

    /**
     * 参数编码
     * 
     * @param data
     * @return
     */
    public static String httpBuildQuery(Map<String, String> data) {
        if (data == null || data.isEmpty()) {
            return "";
        }
        String ret = "";
        String k, v;
        Iterator<String> iterator = data.keySet().iterator();
        while (iterator.hasNext()) {
            k = iterator.next();
            v = data.get(k);
            try {
                ret += URLEncoder.encode(k, CHARSET_UTF8) + "=" + URLEncoder.encode(v, CHARSET_UTF8);
            } catch (UnsupportedEncodingException e) {
            }
            ret += "&";
        }
        return ret.substring(0, ret.length() - 1);
    }

    /**
     * 签名计算
     * 
     * @param params
     * @param appSecret
     * @return
     */
    public static String getSign(Map<String, String> params, String appSecret) {
        Object[] keys = params.keySet().toArray();
        Arrays.sort(keys);
        String k, v;

        String str = "";
        for (int i = 0; i < keys.length; i++) {
            k = (String) keys[i];
            if (k.equals("sign") || k.equals("sign_return")) {
                continue;
            }
            v = (String) params.get(k);

            if ("".equals(v) || "0".equals(v)) {
                continue;
            }
            str += v + "#";
        }
        return Md5.encodeUTF8(str + appSecret);
    }
    
    /**回写数据到客户端
     * 格式：｛"code":200,"msg":"成功","info":JSON对象或者JSON数组｝
     * @param response
     * @param result
     */
	public static void writeDataToClient(HttpServletResponse response, JSONObject result) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=UTF-8");
		ServletOutputStream out = null;
		logger.info("returndata=" + result);
		try {
			out = response.getOutputStream();
			byte[] bytes = StringUtil.getUTF8Bytes(result.toJSONString());
			out.write(bytes);
			out.flush();
		} catch (Exception e) {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e1) {
					logger.error(e1.getMessage());
				}
			}
		}
	}
    
	public static void writeDataToClientJsonp(HttpServletResponse response, JSONObject result, String callback) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		ServletOutputStream out = null;
		try {
			String data = encodeBase64(result.toJSONString());
			JSONObject json = new JSONObject();
			json.put("data", encodeURL(data));
			json.put("sig", Md5.encodeUTF8(data + MD5_KEY));
			out = response.getOutputStream();
			out.println(callback + "(" + json.toJSONString() + ")");
			out.flush();
		} catch (Exception e) {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e1) {
				}
			}
		}
	}
	
	 public static boolean isValidation(Map<String, String> map) {
			if (map == null) {
				return false;
			}
			if (!map.containsKey("sig")) {
				return false;
			}
			String sig = map.get("sig");
			Object[] keys = map.keySet().toArray();
			Arrays.sort(keys);
			StringBuffer buf = new StringBuffer();
			for (int index = 0; index < keys.length; index++) {
				String k = (String) keys[index];
				String v = map.get(k);
				if (!"sig".equals(k)) {
					buf.append("&").append(k).append("=").append(encodeURL(v));
				}
			}
			String sigstr = "";
			if (buf.length() > 0) {
				sigstr = buf.toString().substring(1);
			}
			logger.info("sigstr=" + sigstr);
			String md5 = Md5.encodeUTF8(sigstr + MD5_KEY);
			return md5.equalsIgnoreCase(sig);
		}
	 
	 public static Map<String, Object> getParameterMap(HttpServletRequest request) {
			Map<String, Object> returnMap = new TreeMap<String, Object>();
			Map<String, String[]> requestMap = request.getParameterMap();
			Iterator<Map.Entry<String, String[]>> entries = requestMap.entrySet().iterator();
			Map.Entry<String, String[]> entry = null;
			while (entries.hasNext()) {
				entry = (Map.Entry<String, String[]>) entries.next();
				String name = (String) entry.getKey();
				String value = "";
				Object valueObj = entry.getValue();
				if (null == valueObj) {
					value = "";
				} else if (valueObj instanceof String[]) {
					String[] values = (String[]) valueObj;
					for (int i = 0; i < values.length; i++) {
						value = values[i] + ",";
					}
					value = value.substring(0, value.length() - 1);
				} else {
					value = valueObj.toString();
				}
				returnMap.put(name, value.trim());
			}
			return returnMap;
		}

		public static TreeMap<String, Object> getParameters(HttpServletRequest request) {
			Map<String, String[]> requestMap = request.getParameterMap();
			TreeMap<String, Object> returnMap = new TreeMap<String, Object>();
			Iterator<Map.Entry<String, String[]>> entries = requestMap.entrySet().iterator();
			Map.Entry<String, String[]> entry = null;
			while (entries.hasNext()) {
				entry = (Map.Entry<String, String[]>) entries.next();
				String name = (String) entry.getKey();
				String value = "";
				Object valueObj = entry.getValue();
				if (null == valueObj) {
					value = "";
				} else if (valueObj instanceof String[]) {
					String[] values = (String[]) valueObj;
					for (int i = 0; i < values.length; i++) {
						value = values[i] + ",";
					}
					value = value.substring(0, value.length() - 1);
				} else {
					value = valueObj.toString();
				}
				returnMap.put(name, value.trim());
			}
			return returnMap;
		}

		public static String parseRequest(HttpServletRequest request) {
			BufferedReader br = null;
			StringBuffer buf = new StringBuffer();
			try {
				br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
				String line = null;
				while ((line = br.readLine()) != null) {
					buf.append(line);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (Exception e) {

					}
				}
			}
			return buf.toString();
		}
		
		public static String encodeStringToUTF8(String str) {
			try {
				str = new String(str.getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return str;
		}
	
}
