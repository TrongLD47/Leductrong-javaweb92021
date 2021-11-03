package com.laptrinhjavaweb.utils;

public class StringUtils {
	
	public static boolean IsNullOrEmpty(String str) {
		if (str != null && !str.isEmpty()) {
			return false;
		}
		return true;
	}
}	
