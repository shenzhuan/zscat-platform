package com.zscat.platform.sys.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;

/**
 * 密码工具类定义
 * @author yang.liu
 */
public class PassordUtil {
	
	private static String salt = "fittime";
	private static String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890-_";
	private static int passwordLength = 10;

	public static String encryptPassord(String originPassword) {
		return DigestUtils.md5Hex(originPassword + salt);
	}
	
	public static String getRandomPassword() {
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		for (int i = 0; i < passwordLength; i++) {
			sb.append(chars.charAt(r.nextInt(chars.length())));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
//		for (int i = 0; i < 6; i++) {
//			String pass = getRandomPassword();
////			String pass = "fittime1991";
//			System.out.println(pass + " " + encryptPassord(pass));
//		}
		
	}
}
