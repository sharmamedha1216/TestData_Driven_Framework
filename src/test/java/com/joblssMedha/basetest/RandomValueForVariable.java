package com.joblssMedha.basetest;

import java.util.Random;

import net.bytebuddy.utility.RandomString;

public class RandomValueForVariable {
	
	public static int getRandomIntegerOfSingleDigit(boolean isZeroAllowed) {
		Random rdm = new Random();
		int num=0;
		if(isZeroAllowed) {
			num = rdm.nextInt(10);
		}
		else{
			num = rdm.nextInt(9)+1;
		}
		
		return num;
		
	}
	
	public static int getRandomIntegerOfAnyLength(int iRandomNumLength, boolean isZeroAllowed) {
		Random rdm = new Random();
		int num=0;
		if(iRandomNumLength==1) {
			 num = getRandomIntegerOfSingleDigit(isZeroAllowed);
		}
		else{
			int iMax = (int) Math.pow(10, iRandomNumLength);
			int iMin = (int) Math.pow(10, iRandomNumLength-1);
			num = rdm.nextInt(iMax-iMin)+iMin;
		}
		return num;
	}

	public static void getRandomStringOfAnyLength(int iStringLength, String sStringType) {
		String sRndmStr = "";
		String sAlphabates="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int iRefStringLength=0;
		if (sStringType.contains("Num")){
			sAlphabates = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		}
		
		Random rdm = new Random();
		RandomString rdmStr = new RandomString();
		for(int i =1; i<=iStringLength; i++) {
			int iAlphaNum = rdm.nextInt(sAlphabates.length());
			Character cChar = sAlphabates.charAt(iAlphaNum);
			String sTemp = cChar.toString();
			sRndmStr = sRndmStr+sTemp;
		}
		
		System.out.println(sRndmStr);
		
		
		
	}

}
