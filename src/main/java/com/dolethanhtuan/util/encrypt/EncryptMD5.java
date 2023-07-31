package com.dolethanhtuan.util.encrypt;

import java.math.BigInteger;
import java.security.MessageDigest;

public class EncryptMD5 {
	public static String toMD5(String str) {
		String rs = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes(),0,str.length());
			rs = new BigInteger(1,md.digest()).toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
