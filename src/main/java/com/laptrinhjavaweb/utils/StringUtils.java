package com.laptrinhjavaweb.utils;

import com.laptrinhjavaweb.constant.SystemConstant;

import java.util.Collection;

public class StringUtils {
	//  If dung enums thi ko can utils chi can them thu vien commons-lang3- version3.12.0 la ok
	
	public static boolean IsNullOrEmpty(String str) {
		if (str != null && !str.isEmpty()) {
			return false;
		}
		return true;
	}

}	
