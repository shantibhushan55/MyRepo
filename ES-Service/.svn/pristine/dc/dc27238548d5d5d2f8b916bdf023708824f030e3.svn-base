package com.hp.es.service.util;

public class StringUtils {
	private static char CHAR_TO_REPLACE1='\n';
	private static char CHAR_TO_REPLACE2='\r';
	private static char CHAR_TO_REPLACE3='\t';
	private static char CHAR_TO_TO='§';
	
	public static String cleanStringForTmInsert(String str, int maxLength, boolean notNull) {
		String modifiedString = null;
		if(str != null && str.trim().length()>0) {
			modifiedString = str.trim();
			modifiedString =modifiedString.replace(CHAR_TO_REPLACE1,CHAR_TO_TO);
			modifiedString =modifiedString.replace(CHAR_TO_REPLACE2,CHAR_TO_TO);
			modifiedString =modifiedString.replace(CHAR_TO_REPLACE3,CHAR_TO_TO);
			if(modifiedString.length()>maxLength) {
				
				modifiedString =modifiedString.substring(0, maxLength);
				
			}
		}else {
			if (notNull) {
				modifiedString = "-";
			}
		}
		
		
		return modifiedString;
	}
	
}
