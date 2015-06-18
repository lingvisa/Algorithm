package com.martin.string;


/*
 * Author: Congmin Min
 * Date： 06/17/2015
 * 
 *  Problem: Given a string ‘str’ of digits, find length of the longest substring of ‘str’, such that the length of 
 *           the substring is 2k digits and sum of left k digits is equal to the sum of right k digits.
 *  
 *  Examples:
 *  Input: str = "123123"
 *	Output: 6            // the length of the longest substring '123123'
 *	The complete string is of even length and sum of first and second
 *	half digits is same. Here k=3. Sum of left '123' = sum of right '123'. 
	
 *	Input: str = "1538023"
 *	Output: 4                // the length of the longest substring '5380'
 *	The longest substring with same first and second half sum is "5380"
 *	Here k=2. Sum of left '53' = sum of right '80'.
 * 
 * 
 *  Algorithm: for each possible substring sub[i,j] where i>=0 & j<str.length, find whether the sum of "left k" digits 
 *             is equal to the sum of "right k" digits.
 *             
 *  Complexity: O(N^2)           
 * 
 * */
public class LongestEvenLengthStr {

	
	public static int longestEvenLength(String str) {
		
		int max = 0;
		for(int i=0; i<str.length(); i++) {
			for(int j=i+2; j<=str.length(); j++){
				int temp = longest(str.substring(i,j));
				if(max<temp){
					max = temp;
				}
			}
		}
		
		return max;
	}
	
	// to test whether sum of str[i,mid) == sum of [mid,2*mid)
	private static int longest(String str) {
		
		int length = str.length();
		int mid = length/2;

		int leftSum = 0;
		int rightSum = 0;
		int max = 2 * mid;
		
		// the upper bound is 'mid'
		for(int i=0; i<mid; i++) {
			leftSum += Character.getNumericValue((str.charAt(i)));
		}
		
		// NOTE that the upper bound is 'max', NOT 'length-1'
		for(int i=mid; i<max; i++) {
			rightSum += Character.getNumericValue((str.charAt(i)));
		}

		if(leftSum == rightSum) {
			return max;
		}

		return 0;
	}
	
	static void testLongestEvenLengthStr() {
		
		assert longestEvenLength("123123")==6;
		assert longestEvenLength("1538023")==4;
		assert longestEvenLength("1537023")==6;
		assert longestEvenLength("1537013")==0;
		assert longestEvenLength("1")==0;
		assert longestEvenLength("12")==0;
		assert longestEvenLength("11")==2;
		assert longestEvenLength("111")==2;
		
		System.out.println("testLongestEvenLengthStr()!!!");
	}
	
	public static void main(String[] args) {
		
		testLongestEvenLengthStr();
	}

}
