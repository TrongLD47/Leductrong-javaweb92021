package com.laptrinhjavaweb.utils;

import com.laptrinhjavaweb.constant.SystemConstant;

import java.util.Collection;

public class ValidateUtils {

    public static boolean isValid(Object obj){
        boolean isTrue = null != obj && !SystemConstant.EMPTY_STRING.equals(obj.toString());

        if(isTrue){
            if(obj instanceof  String){
                return true;
            }else if(obj instanceof Integer){
                return true;
            }else if(obj instanceof Collection){
                return !((Collection<?>) obj).isEmpty();
            }
        }
        return false;
    }
}
