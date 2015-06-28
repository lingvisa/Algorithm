package com.martin.dp;

/*
 * Definition:
 * 
 * n! = 1 if    n=0;
 *        else  n * n(n-1)! (n>0)
 * 
 * Example: 5! = 5 * 4 * 3 * 2 * 1 = 120
 * 
 * 
 * 
 * 
 * 
 * 
 * */

public class Factorial {

	
	static int iterative(int n) {
		
		int product = 1;
		for(int i=1; i<=n; i++) {
			product *=  i;
		}
		
		return product;
	}
	
	static int recursive(int n) {

		if(n==0) {
			return 1;
		}else{
			return n*recursive(n-1);
		}
	}
	
	static void test() {
		
		assert iterative(5) == 120;
		assert iterative(0) == 1;
		assert recursive(5) == 120;
		assert recursive(0) == 1;
		
		System.out.println("Test factorial successful!");
	}
	
	public static void main(String[] args) {
		test();
	}
}
