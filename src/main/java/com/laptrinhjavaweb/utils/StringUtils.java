package com.laptrinhjavaweb.utils;

public class StringUtils {
	//  If dung enums thi ko can utils chi can them thu vien commons-lang3- version3.12.0 la ok
	
	public static boolean IsNullOrEmpty(String str) {
		if (str != null && !str.isEmpty()) {
			return false;
		}
		return true;
	}
}	
