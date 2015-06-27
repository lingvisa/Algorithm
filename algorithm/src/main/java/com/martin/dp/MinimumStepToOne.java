package com.martin.dp;

/*
 * Author: Congmin Min
 * Date: 06/26/2015
 * 
 * Problem: On a positive integer, you can perform any one of the following 3 steps:
 *          1) Subtract 1 from it, i.e. n = n-1;
 *          2) If it is divisible by 2, divide by 2, i.e. if n%2==0, n=n/2;
 *          3) If it is divisible by 3, divide by 3, i.e. if n%3==0, n=n/3;
 *          
 *          Now, given a positive Integer N, find the minimum number of steps that takes N to 1.
 * 
 * Examples:
 *         1) for N=1, output==0: N is already the goal, 1
 *         2) for N=4, output==2: 4/2=2; 2/2=1
 *         3) for N=7, output==3: 7-1=6; 6/3=2; 2/2=1 Or
 *                                7-1=6; 6/2=3; 3-1=2, 2/2=1: This takes 4 steps, not optimal.
 * 
 * Algorithm: 
 * 		1. Memoization:	F(n) =   1 + min{ F(n-1), F(n/2), F(n/3) }  if (n>1) 
 *                               else 0  ( i.e., F(1) = 0 )
 *      2. Bottom-up DP:                           
 * */

public class MinimumStepToOne {


	// Algorithm 1: Bottom-up DP
	static int dp(int n) {

		int[] store = new int[n+1];
		
		// Start with the initial case, whose value is already known, later computations will be gradually built on top of this very initial value
		// This is the dESIGN PATTERN here !
		store[1] = 0;

		for(int i=2; i<=n; i++) {
			
			store[i] = 1+store[i-1];
			
			if(i%2==0) {
				store[i] = min(store[i], 1+store[i/2]);
			}
			
			if(i%3==0) {
				store[i] = min(store[i], 1+store[i/3]);
			}
		}

		return store[n];
	}
	
	// Algorithm 2: Memoization
	static int memoization(int n) {

		int[] memo = new int[n+1];
		for(int i=1; i<=n; i++){
			memo[i] = -1;
		}

		return helper(n, memo);		
	}

	static int helper(int n, int[]memo) {

		if(n==1){
			return 0;
		}

		// if F(n) is already computed, return its value (steps), no need to compute again; 
		if(memo[n] != -1) {
			return memo[n];
		}

		// F(n-1) is always necessary to compute, then compare it with other two possible values, which are conditioned on n%2==0 or n%3==0.
		int step = 1+ helper((n-1), memo);

		if(n%2==0) {
			step = min(step, 1+helper(n/2, memo));	
		}
		if(n%3==0) {
			step = min(step, 1+helper(n/3, memo));
		}

		// once the minimum step is found, stored it in the array
		memo[n] = step;

		return step;		
	}


	private static int min(int m, int n) {
		if(m<= n)
			return m;
		else
			return n;
	}
	
	static void test() {

		assert memoization(1)==0;
		assert memoization(4)==2;
		assert memoization(5)==3;
		assert memoization(6)==2;
		assert memoization(7)==3;
		assert memoization(10)==3;

		assert dp(1)==0;
		assert dp(4)==2;
		assert dp(5)==3;
		assert dp(6)==2;
		assert dp(7)==3;
		assert dp(10)==3;

		
		System.out.println("Test minimumStepToOne() successful!");
	}

	public static void main(String[] args) {
		
		test();
	}
}
