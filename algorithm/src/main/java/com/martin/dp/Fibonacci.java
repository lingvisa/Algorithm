package com.martin.dp;

/*
 * Author: Congmin Min
 * Date: 06/26/2015
 * 
 * Fib(n) = Fib(n-1) + Fib(n-2);
 * 
 * F(1) =1, F(2) = 1;
 * 
 * Fib(4) = Fib(3) + Fib(2)
 *        = Fib(2) + Fib(1) + Fib(1) + Fib(0)
 *        = Fib(1) + Fib(0) + Fib(1) + Fib(1) + Fib(0)
 * 
 * Algorithm: 
 *     Recursion: Based on mathematical reduction
 *     DP: Store intermediate results in an array, and make it available to immediate next computation!
 *     
 * 
 * */

public class Fibonacci {

	static int recursive(int n) {
		
		if(n==1 || n==2) {
			return 1;
		}else{
			return recursive(n-1) + recursive(n-2);
		}		
	}
	
	static int dp(int n) {
		
		if(n==1 || n==2) {
			return 1;
		}
		
		int[] fibonacci = new int[n];
		
		fibonacci[0] = 1;
		fibonacci[1] = 1;
		
		for(int i=2; i<n; i++) {
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
		}
		
		return fibonacci[n-1];
	}
	
	static void test() {
		
		assert recursive(20) == 6765;
		assert dp(20) == 6765;
		assert recursive(1) == 1;
		assert dp(1) == 1;
		assert recursive(2) == 1;
		assert dp(2) == 1;
		
		System.out.println("Test Finonacci successful!");
	}
	
	public static void main(String[] args) {
		
		test();
	}

}
