package com.capgemini.librarymanagementsystem.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
	public Boolean validateId(String id) {
		Pattern pat = Pattern.compile("\\d+");
		Matcher mat = pat.matcher(id);
		if(mat.matches()){
			return true;
		}else{
			return false;
		}
	}
	public Boolean validateEmail(String email) {
		Pattern pat = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		Matcher	mat = pat.matcher(email);
		if(mat.matches()){
			return true;
		}else{
			return false;
		}
	}	
	public Boolean validatePassword(String password) {
		
		Pattern pat = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,7})");
		Matcher	mat = pat.matcher(password);
		if(mat.matches()){
			return true;
		}else{
			return false;
		}
	}
}