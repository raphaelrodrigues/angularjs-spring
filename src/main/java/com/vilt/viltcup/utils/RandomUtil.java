package com.vilt.viltcup.utils;

import java.util.Random;

public final class RandomUtil {

	    
	    public static final String LETTER_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    public static final String LETTER_LOWER = "abcdefghijklmnopqrstuvwxyz";
	    public static final String DIGIT = "0123456789";
	    
	    public static String RandomString(String prefix,int length) {
	        StringBuilder sb = new StringBuilder(prefix == null ? "" : prefix);
	        int size = sb.length() + length;
	        while( sb.length() < size){
	            sb.append( LETTER_LOWER.charAt( randomNumber( 0 , LETTER_LOWER.length() - 1)) );
	        }
	        
	        return sb.toString();
	    }
	    
	    public static int randomNumber(int min, int max){
	        Random rand = new Random();
	        int range = max - min + 1;
	        // nextInt is normally exclusive of the top value
	        int randomNum = rand.nextInt(range) + min;
	        
	        return randomNum;
	    }
	    
	    public static String friendlyUrl(String name){
	    	//build the title that appears in the URL when accessing a podcast from the main application
	    	String titleInUrl = name.trim().replaceAll("[^a-zA-Z0-9\\-\\s\\.]", "");
	    	titleInUrl = titleInUrl.replaceAll("[\\-| |\\.]+", "-");
	    	return titleInUrl;
	    }

	}
