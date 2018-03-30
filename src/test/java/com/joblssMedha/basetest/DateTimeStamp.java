package com.joblssMedha.basetest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeStamp {
	static Date oDate = new Date();
	static SimpleDateFormat oSDF ;

	public static void main(String[] args) {
		
	}
	
	
	/**
	 * getDateAndOrTimeStamp(String);
	 * @param sDateAndOrTimeFormat : Input format of the required DateAndOrTime Stamp
	 * @return System DateAndOrTime Stamp (according to the provided format for parameter sDateAndOrTimeFormat), as a String. 
	 **/
	public static String getDateAndOrTimeStamp(String sDateAndOrTimeFormat) {
		oSDF = new SimpleDateFormat(sDateAndOrTimeFormat);
		String sDateNTime = oSDF.format(oDate);
		return sDateNTime;
	}

	
	/**
	 * getPastDateAndOrTime(String, String, int, int);
	 * @param sDateAndOrTime : Input Any String or get System DateTimeStamp using "getDateAndOrTimeStamp(String sDateAndOrTimeFormat)" method.
	 * @param sDateAndOrTimeFormat : Input format of above parameter "sDateAndOrTime" value
	 * @param iUnitOfChange : Get it from ProjectConstants.Java page, based which Factor to be considered to update the DateTimeStamp
	 * @param iNumOfTimeUnit : Number by which the DateTimeStamp is to be update with reference to Unit mentioned as parameter "iUnitOfChange" value.
	 * @return Updated past DateTimeStamp as a String.
	 **/
	public static String getPastDateAndOrTime(String sDateAndOrTime, String sDateAndOrTimeFormat, int iUnitOfChange,int iNumOfTimeUnit) {
		
		oSDF = new SimpleDateFormat(sDateAndOrTimeFormat);
		Date dDateAndOrTime=null;
		try {
			dDateAndOrTime = oSDF.parse(sDateAndOrTime);
		} catch (ParseException e) {
			System.out.println("Given DateTime Stamp is not parsable");
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(dDateAndOrTime);
		cal.add(iUnitOfChange, -iNumOfTimeUnit);
		Date dPastDateAndOrTime = cal.getTime();
		String sPastDateAndOrTime = oSDF.format(dPastDateAndOrTime);
		return sPastDateAndOrTime;
	}
	
	
	/**
	 * getPastDateAndOrTime(String, String, int, int);
	 * @param sDateAndOrTime : Input Any String or get System DateTimeStamp using "getDateAndOrTimeStamp(String sDateAndOrTimeFormat)" method.
	 * @param sDateAndOrTimeFormat : Input format of above parameter "sDateAndOrTime" value
	 * @param iUnitOfChange : Get it from ProjectConstants.Java page, based which Factor to be considered to update the DateTimeStamp
	 * @param iNumOfTimeUnit : Number by which the DateTimeStamp is to be update with reference to Unit mentioned as parameter "iUnitOfChange" value.
	 * @return Updated future DateTimeStamp as a String.
	 **/
	public static String getFutureDate(String sDateAndOrTime, String sDateAndOrTimeFormat, int iUnitOfChange, int iNumOfTimeUnit) {
		
		oSDF = new SimpleDateFormat(sDateAndOrTimeFormat);
		Date dDateAndOrTime=null;
		try {
			dDateAndOrTime = oSDF.parse(sDateAndOrTime);
		} catch (ParseException e) {
			System.out.println("Given DateTime Stamp is not parsable");
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(dDateAndOrTime);
		cal.add(iUnitOfChange, +iNumOfTimeUnit);
		Date dFutureDateAndOrTime = cal.getTime();
		String sFutureDateAndOrTime = oSDF.format(dFutureDateAndOrTime);
		return sFutureDateAndOrTime;
	}

}
