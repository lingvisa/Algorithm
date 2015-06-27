package com.martin.dp;

import java.util.HashMap;
import java.util.Map;

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
 *     1. Recursion: Based on mathematical reduction
 *     2. DP Bottom Up: Store intermediate results in an array, and make it available to immediate next computation!
 *     3. Memoization Up Bottom: Store intermediate results in recursive version 
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
		
		int[] fibonacci = new int[n+1];
		
		fibonacci[1] = 1;
		fibonacci[2] = 1;
		
		for(int i=2; i<=n; i++) {
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
		}
		
		return fibonacci[n];
	}
	
	static int memoization(int n) {
		
		Map<Integer, Integer> store = new HashMap<Integer, Integer>();
		store.put(1, 1);
		store.put(2, 1);
		
		return helper(n, store);
	}
	
	// F(3) = F(2) + F(1)
	private static int helper(int n, Map<Integer, Integer> store) {
		
		Integer value = store.get(n);
		if(value !=null){
			return value;
		}
		
		value = helper(n-1, store) + helper(n-2, store);
		store.put(n, value);
		
		return value;
	}
	
	static void test() {
		
		assert recursive(20) == 6765;
		assert dp(20) == 6765;
		assert memoization(20) == 6765;
		
		assert recursive(1) == 1;
		assert dp(1) == 1;
		assert memoization(1) == 1;
		
		assert recursive(2) == 1;
		assert dp(2) == 1;
		assert memoization(2) == 1;
		
		System.out.println("Test Finonacci successful!");
	}
	
	public static void main(String[] args) {
		
		test();
		System.out.println(memoization(4));
	}

}
