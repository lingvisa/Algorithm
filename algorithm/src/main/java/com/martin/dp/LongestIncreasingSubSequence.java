package com.martin.dp;


/*
 * Author: Congmnin Min
 * Date: 06/26/2015
 * 
 * Problem description:

 * The Longest Increasing Subsequence problem is to find the longest increasing subsequence of a given sequence. 
 * Given a sequence S= {a1 , a2 , a3, a4, ............., an-1, an } we have to find a longest subset such that for all j and i,  j<i in the subset aj<ai.

 * Example:
 *  sequence = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
 *  The longest increasing subsequence is longest_sequence = [0, 2, 6, 9, 11, 15], where each element is sorted in increasing order, and its length is 6. 
 *  There is no chance to find another sorted increasing sub-sequence whose length would be "7".
 * Implement both brute-force, and more efficient dynamic programming methods.
 * 
 * Algorithm:
 *      Step 1: for each index 0<=i<n, find the largest length of subsequence L at index i, and store each L into an array
 *              
 *               
 *      Step 2: Go through the array and find the largest length L' of the whole sequence
 *
 * */

public class LongestIncreasingSubSequence {

	
	/*
	 * Input: sequence = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
	 * Output: 6
	 * 
	 * */
	static int lisLength(int[] sequence) {
		
		int length = sequence.length;
		int[] sub = new int[length];
		
		for(int i=0; i<length; i++) {
			// Initialize the DP used first value
			sub[i] = 1;
			for(int j=0; j<i; j++) {
				if(sequence[i]>sequence[j] && sub[i]<=sub[j] ){
					// directly fetch value from the DP variable without re-caculation.
					sub[i] = sub[j]+1;
				}
			}
		}
		
		// Find the largest element in the DP array
		int largest = 0;
		for(int i=0; i<length; i++){
			if(largest<sub[i]) {
				largest = sub[i];
			}
		}
		
		return largest;
	}
	
	static void test() {
		
		int[] sequence = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		int[] sequence1 = {0, 13, 3, 11, 7, 15};
		int[] sequence2 = {10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		int[] sequence3 = {0, 0, 11, 7, 15};
		
		assert lisLength(sequence)==6;
		assert lisLength(sequence1)==4;
		assert lisLength(sequence2)==4;
		assert lisLength(sequence3)==3;
		
		System.out.println("test lisLength() successful!");
	}
	
	public static void main(String[] args) {
	
		test();

	}

}
