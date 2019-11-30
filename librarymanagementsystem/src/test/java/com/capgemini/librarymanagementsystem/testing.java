package com.capgemini.librarymanagementsystem;

import java.text.SimpleDateFormat;
import java.util.Date;

public class testing {


	private static long daysBetween(Date one, Date two) {
		long difference =  (one.getTime()-two.getTime())/86400000;
		return Math.abs(difference);
	}
	public static void main(String[] args) {
		String two = "yyyy-MM-dd";
		try {
			SimpleDateFormat dateFormat  = new SimpleDateFormat(two);
			Date date = dateFormat.parse("2018-09-09");
			Date date2 = dateFormat.parse("2018-09-23");
			System.out.println(testing.daysBetween(date, date2));
		}
		catch (Exception e) {
			System.out.println("sdfgh");
		}

	}

}
