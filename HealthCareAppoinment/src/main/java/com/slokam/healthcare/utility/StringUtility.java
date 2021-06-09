package com.slokam.healthcare.utility;

public class StringUtility {
	public static boolean blankCheck(String str){
		boolean flag=false;
		if(str!=null && str.trim().length()>0) {
			flag=true;
			return flag;
		}
		return flag;
		}
}
