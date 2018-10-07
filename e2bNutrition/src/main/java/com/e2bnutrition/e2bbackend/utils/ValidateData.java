package com.e2bnutrition.e2bbackend.utils;

public class ValidateData {
	
	public static boolean isUsed(String genericString) {
		
		if((genericString==null)||(genericString.isEmpty()))
				return false;
		
		else return true;
	}
	
	public static boolean isUsed(Long genericInt) {
		
		if((genericInt == null)||(genericInt<0))
				return false;
		
		else return true;
	}

}
