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
	
		if( str == null || str.isEmpty()) {
			return false;
		}
		
		int left = 0;
		int right = str.length()-1;
		
		while( left <= right ) {
			
			char leftChar = Character.toLowerCase(str.charAt(left));
			char rightChar = Character.toLowerCase(str.charAt(right));
			
			
			if(!Character.isAlphabetic(leftChar) && !Character.isDigit(leftChar)) {
				left++;
				continue;
			}

			if(!Character.isAlphabetic(rightChar) && !Character.isDigit(rightChar)) {
				right--;
				continue;
			}
			
			left++;
			right--;
			
			if(leftChar != rightChar ) {
				return false;
			}
		}
		
		return true;
	}
	
	static boolean isPalindrome2(String str) {
		
		if( str == null || str.isEmpty()) {
			return false;
		}
		
		int left = 0;
		int right = str.length()-1;
		int mid = 2/str.length();
		
		while( left <= right ) {
			
			char leftChar = Character.toLowerCase(str.charAt(left));
			char rightChar = Character.toLowerCase(str.charAt(right));
			
			
			while( left <=right && !Character.isAlphabetic(leftChar) && !Character.isDigit(leftChar)) {
				left++;
			}

			while(right >= mid && !Character.isAlphabetic(rightChar) && !Character.isDigit(rightChar)) {
				right--;
			}
			
			leftChar = Character.toLowerCase(str.charAt(left));
			rightChar = Character.toLowerCase(str.charAt(right));
			
			if(leftChar != rightChar ) {
				return false;
			}
			
			left++;
			right--;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		
		String str1 = "A man, a plan, a canal: Panama";
		String str2 = "race a car";
		
		assert isPalindrome(str1)==true;
		assert isPalindrome(str2)==false;
		
		System.out.println("Testing successful!");
	}
}
