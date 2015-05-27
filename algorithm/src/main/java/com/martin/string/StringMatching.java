package com.martin.string;

public class StringMatching {

	/*
	 *  Problem: Returns the index within the string 'str' of the first occurrence of the specified substring 'pattern'. 
	 *  Example: indexOf("abcde", "de") == 3         
	 * 
	 * */
	static int indexOf(String str, String pattern) {

		// or throw InvalidArgumentException
		if(str==null || pattern==null || pattern.isEmpty()) {
			return -1;
		}

		if(pattern.length() > str.length()) {
			return -1;
		}

		// max possible value of the index of the first match
		int max = str.length() - pattern.length();		
		for(int i=0; i<=max; i++) {
			int j=0;
			int k=i;
			while(j<pattern.length()){
				if(str.charAt(k) != pattern.charAt(j)) {
					break;
				}else{
					j++;
					k++;
				}
			}

			// find the first match
			if(j==pattern.length()) {
				return i;
			}
		}

		return -1;
	}
	
	public static void main(String[] args) {
		
		assert indexOf("abcde", "de") == 3;
		assert indexOf("abcde", "abc") == 0;
		assert indexOf("abcde", "cd") == 2;
		assert indexOf("abc", "abcd") == -1;
		assert indexOf("a", "x") == -1;
		assert indexOf("abcde", "") == -1;
		
		System.out.println("Testing successful!");
		
	}

}
