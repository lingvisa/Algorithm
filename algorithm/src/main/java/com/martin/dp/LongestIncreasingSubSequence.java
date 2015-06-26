package com.martin.dp;

import java.util.ArrayList;

/*
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
 *
 * */

public class LongestIncreasingSubSequence {

	/* First version, which doesn't work! */
	static Object[] lis(int[] sequence) {
		
		int length = sequence.length;
		
		ArrayList<Integer> maxSequence = new ArrayList<Integer>();
		for(int i=0; i<length-1; i++) {
			int initial = sequence[i];
			for(int j=i+1; j<length; j++){
				ArrayList<Integer> subSequence = new ArrayList<Integer>();
				subSequence.add(initial);
				
				int current = initial;
				
				int k = j;
				while(k<length) {
					int next = sequence[k];	
					if(current<next){
						subSequence.add(next);
						current = next;
					}
					k++;
				}
				if(maxSequence.size() < subSequence.size()){
					maxSequence = subSequence;
				}				
			}
		}
		
		return maxSequence.toArray();
	}
	
	static void testLis() {
		
		int[] sequence = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		for(Object o : lis(sequence)) {
			System.out.print(o + " ");
		}
		System.out.println(lis(sequence).toString());
	}
	
	public static void main(String[] args) {
	
		testLis();

	}

}
