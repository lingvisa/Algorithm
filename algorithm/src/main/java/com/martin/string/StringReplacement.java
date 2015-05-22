package com.martin.string;

/*
 *  Author:   Congmin Min
 *  Date:     05/21/2015
 *  Version:  1.0
 * 
 * */

/*
 *  Replace occurrences of string X with Y in Z 
 *  For example: X=abc Y = ab Z=abcdabcc
 *  replaceFirst(X, Y, Z) = abdabcc
 *  replaceAll(X, Y, Z) = abdabc
 *   
 **/
public class StringReplacement {

	
	static String replaceFirst(String pattern, String replacement, String original) {
	
		int origSize = original.length();
		int pattSize = pattern.length();		
		
		if(original==null || pattern==null || replacement ==null ) {
			return null;
		}
		
		if(pattern.isEmpty()) {
			return original;
		}
		
		if(origSize<pattSize) {
			return original;
		}
		
		int i = 0;
		int p = 0;
		
		while(i<origSize) {
			int j=0;
			boolean isFirst = false;
			while(i<origSize && j<pattSize) {
				
				if(original.charAt(i)==pattern.charAt(j)){
					
					if(!isFirst) {
						isFirst = true;
						p = i;
					}					
					i++;
					j++;
				}else{
					i++;
					break;
				}
			}
			// find the first full match
			if(j==pattSize) {
				
				StringBuilder sb = new StringBuilder();
				for(int k=0; k<p; k++) {
					sb.append(original.charAt(k));
				}
				for(int k=0; k<replacement.length(); k++){
					sb.append(replacement.charAt(k));
				}
				for(int k=i; k<origSize; k++){
					sb.append(original.charAt(k));
				}
				return sb.toString();
			}
		}
		
		return original;
	}
	
	static String replaceAll(String pattern, String replacement, String original) {
		
		if(original==null || pattern==null || replacement ==null ) {
			return null;
		}
		
		if(pattern.isEmpty()) {
			return original;
		}
		
		if(original.length()<pattern.length()) {
			return original;
		}
		
		StringBuilder sb = new StringBuilder();
		
		return replaceHelper(pattern, replacement, original, sb);
	}
	
	static String replaceHelper(String pattern, String replacement, String original, StringBuilder builder) {
		
		int origSize = original.length();
		int pattSize = pattern.length();
		
		if(origSize<pattSize){			
			return builder.append(original).toString();
		}
		
		int i=0;
		int p=0;
		
		while(i<origSize){
			int j=0;
			boolean isFirst = false;
			
			while(i<origSize && j<pattSize){
				
				if(original.charAt(i)==pattern.charAt(j)){
					
					if(!isFirst){
						isFirst=true;
						p=i;
					}
					i++;
					j++;
				}else{
					i++;
					break;
				}
			}
			
			// find the first match
			if(j==pattSize){
				
				for(int k=0; k<p; k++){
					builder.append(original.charAt(k));
				}
				for(int k=0; k<replacement.length(); k++){
					builder.append(replacement.charAt(k));
				}
				
				// recursively process remaining characters by looking for next match
				return replaceHelper(pattern, replacement, original.substring(i), builder);
			}
		}
		
		return builder.append(original).toString();
	}

	static void testReplaceFirst() {

		assert (replaceFirst("ab", "abc", "abcabc")).equals("abccabc");
		assert (replaceFirst("ab", "ab", "abcabc")).equals("abcabc");
		assert (replaceFirst("ab", "a", "abcabc")).equals("acabc");
		assert (replaceFirst("abc", "ab", "abcabc")).equals("ababc");

		assert (replaceFirst("abcd", "ab", "abcabc")).equals("abcabc");
		assert (replaceFirst("cabc", "ab", "abcabc")).equals("abab");

		assert (replaceFirst("", "ab", "abcabc")).equals("abcabc");
		assert (replaceFirst("abc", "", "abcabc")).equals("abc");
		assert (replaceFirst("abcabc", "", "abcabc")).equals("");

		System.out.println("replaceFirst() successful!");
	}

	static void testReplaceAll() {

		assert (replaceAll("ab", "abc", "abcabc")).equals("abccabcc");
		assert (replaceAll("ab", "ab", "abcabc")).equals("abcabc");
		assert (replaceAll("ab", "a", "abcabc")).equals("acac");
		assert (replaceAll("abc", "ab", "abcabc")).equals("abab");

		assert (replaceAll("abcd", "ab", "abcabc")).equals("abcabc");
		assert (replaceAll("cabc", "ab", "abcabc")).equals("abab");

		assert (replaceAll("", "ab", "abcabc")).equals("abcabc");
		assert (replaceAll("abc", "", "abcabc")).equals("");
		assert (replaceAll("abcabcabc", "", "abcabc")).equals("abcabc");

		System.out.println("replaceAll() successful!");
	}

	public static void main(String[] args) {

		testReplaceFirst();
		
		testReplaceAll();
	}
}
