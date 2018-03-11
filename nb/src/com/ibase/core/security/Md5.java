package com.ibase.core.security;

import com.ibase.core.utils.StringUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * MD5加密算法
 * @author admin
 *
 */
public class Md5 {
	
	public static final String CHARSET_UTF8 = "UTF-8";
    public static final String CHARSET_GBK = "GBK";
  
    /**
     * 将UTF编码字符串按MD5加密算法加密
     * @param arg
     * @return
     */
    public static String md5UTF(String arg) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("加密出错");
        }
        digest.update(StringUtil.getUTF8Bytes(arg));
        byte[] binaryData = digest.digest();
        return HexBin.encode(binaryData).toLowerCase();
    }

    /**
     * 将GBK编码字符串按MD5加密算法加密
     * @param arg
     * @return
     * @throws Exception
     */
    public static String md5GBK(String arg) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(StringUtil.getGBKBytes(arg));
        byte[] binaryData = digest.digest();
        return HexBin.encode(binaryData);
    }

    /**
     * 将默认编码字符串按MD5加密算法加密
     * @param arg
     * @return
     * @throws Exception
     */
    public static String md5(String arg) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(StringUtil.getBytes(arg));
        byte[] binaryData = digest.digest();
        return HexBin.encode(binaryData);
    }

    public static String md5File(String file) {

        FileInputStream fis = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            fis = new FileInputStream(file);
            byte[] buf = new byte[1024];
            int l = 0;
            while ((l = fis.read(buf)) > 0) {
                digest.update(buf, 0, l);
            }
            byte[] binaryData = digest.digest();
            return HexBin.encode(binaryData);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                }
            }
        }
        return null;
    }
    
    
    public static String encode(String str,String charset) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(str.getBytes(charset));
            byte bytes[] = m.digest();
            return toHex(bytes);
        } catch (Exception e) {
        }
        return "";
    }
    
    
    public static String encodeUTF8(String str) {
        return encode(str, CHARSET_UTF8);
    }
    
    public static String encodeGBK(String str) {
        return encode(str, CHARSET_GBK);
    }
    
    public static String toHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            if ((bytes[i] & 0xff) < 0x10) {
                sb.append("0");
            }
            sb.append(Integer.toString(bytes[i] & 0xff, 16));
        }
        return sb.toString();
    }
}
