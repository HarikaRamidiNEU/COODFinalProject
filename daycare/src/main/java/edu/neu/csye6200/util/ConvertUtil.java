package edu.neu.csye6200.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertUtil {
	
	public static int strToInt(String integer) {
		try {
			return Integer.parseInt(integer);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static Date strToDate(String date) {
		if (date.equals(" ") || date == null || date.isEmpty()) {
			return null;
		} else {
			try {
				return new SimpleDateFormat("MM/dd/yyyy").parse(date);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}
}
