package com.krho.finalproject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class APISetDate {
	 
	private static Date today = new Date(); 
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
	public static String TODAY =df.format(today);
	private static SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMdd");
	public static String TODAY2 =df2.format(today);
	public static String ZIPCODE = "48226";

}
