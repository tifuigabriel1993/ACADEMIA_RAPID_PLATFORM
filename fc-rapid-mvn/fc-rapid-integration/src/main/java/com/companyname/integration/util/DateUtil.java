package com.companyname.integration.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String formatActivityDate(Date date) {
		DateFormat df = new SimpleDateFormat("dd, MMMM yyyy");
		return date != null ? df.format(date) : "";
	}

	public static String formatDate(Date date) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return df.format(date);
	}

	public static Date parseDate(String date) {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
