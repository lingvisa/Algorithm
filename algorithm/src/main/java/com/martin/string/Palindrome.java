package com.martin.string;

public class Palindrome {
	
	
	/*
	 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	 *	For example,
	 *	"A man, a plan, a canal: Panama" is a palindrome.
	 *	"race a car" is not a palindrome.
	 * 
	 *  Algorithm: Compare character by character, two pointers moving to each other; if any comparison fails, return false; otherwise, true
	 */
	static boolean isPalindrome(String str) {
	
		if(str.isEmpty() || str == null) {
			return false;
		}
		
		int left = 0;
		int right = str.length() -1;
		
		while( left <= right ) {
			
			char l = Character.toLowerCase(str.charAt(left));
			char r = Character.toLowerCase(str.charAt(right));
			
			
			if(!Character.isAlphabetic(l) && !Character.isDigit(l)) {
				left++;
				continue;
			}

			if(!Character.isAlphabetic(r) && !Character.isDigit(r)) {
				right--;
				continue;
			}
			
			left++;
			right--;
			
			if(l != r ) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		
		String str1 = "A man, a plan, a canal: Panama";
		String str2 = "race a car";
		
		assert isPalindrome(str1)==true;
		assert isPalindrome(str2)==false;
	}
}
