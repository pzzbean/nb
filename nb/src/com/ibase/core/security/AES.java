package com.ibase.core.security;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;


public class AES {

	private static final String KEY_ALGORITHM = "AES";
	private static final String AES_ALGORITHM = "AES/CBC/PKCS5Padding";
	protected static final String AES_ALGORITHM1 = "AES/ECB/PKCS5Padding";
	
	private static final String CHARSET_UTF8 = "UTF-8";

	public static String encrypt(String password, String data) throws Exception {
		SecretKeySpec skeySpec = getKey(password);
		Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, getIvSpec());
		byte[] encrypted = cipher.doFinal(data.getBytes(CHARSET_UTF8));
		return Base64.encodeBase64String(encrypted);
	}

	public static String decrypt(String password, String data) throws Exception {
		SecretKeySpec skeySpec = getKey(password);
		Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, getIvSpec());
		byte[] encrypted = Base64.decodeBase64(data);
		byte[] original = cipher.doFinal(encrypted);
		String originalString = new String(original,CHARSET_UTF8);
		return originalString;
	}
	
	/**
	 * 新增
	 * @param password
	 * @param data
	 * @param iv
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String password, String data,String iv) throws Exception {
		SecretKeySpec skeySpec = getKey(password);
		Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(iv.getBytes()));
		byte[] encrypted = Base64.decodeBase64(data);
		byte[] original = cipher.doFinal(encrypted);
		String originalString = new String(original,CHARSET_UTF8);
		return originalString;
	}

	private static SecretKeySpec getKey(String password) throws Exception {
		byte[] arrBTmp = password.getBytes(CHARSET_UTF8);
		byte[] arrB = new byte[16]; // 创建一个空的16位字节数组（默认值为0）
		for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
			arrB[i] = arrBTmp[i];
		}
		return new SecretKeySpec(arrB, KEY_ALGORITHM);
	}

	public static IvParameterSpec getIvSpec() {
		return new IvParameterSpec("0102030405060708".getBytes());
	}

	public static void main(String[] args) throws Exception {
		String msgString = "root";
		String password = "o51gaoqingij5dpeerusypojro9lu9rt";
		String content1 = AES.encrypt(password, msgString);
		System.out.println();
		System.out.println(content1);
		System.out.println();
		String content = AES.decrypt(password, content1);
		System.out.println(content);
	}

}
