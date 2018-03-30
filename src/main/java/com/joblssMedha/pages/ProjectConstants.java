package com.joblssMedha.pages;

import java.util.Calendar;

public class ProjectConstants {
	
	Calendar cal = Calendar.getInstance();
	public final int cal_DAY = cal.DATE;
	public final int cal_MONTH = cal.MONTH;
	public final int cal_YEAR = cal.YEAR;
	public final int cal_HOUR = cal.HOUR;
	public final int cal_MINUTE = cal.MINUTE;
	public final int cal_SECOND = cal.SECOND;
	public final int VERY_SMALL_WAIT = 5;
	public final int SMALL_WAIT = 10;
	public final int MEDIUM_WAIT = 20;
	public final int LONG_WAIT = 30;
	public final int VERY_LONG_WAIT = 60;
	public static final String Location_PropertiesFile = "D:\\Workspace_Project\\Kismat\\resources\\projectApplication.properties";
	public static final String Location_ExcelTestData = "D:\\Workspace_Project\\Kismat\\resources\\Project_TestDataxls.xls";
	
}
