package com.martin.dp;

public class Minimum {

	static int functionA(int n) {
		return n;
	}
	
	static int functionB(int n) {
		return n-1;
	}
	
	static int functionC(int n) {
		return n+1;
	}
	
	static int findMinimum(int n) {
		
		return 0;
	}
	
	static int minimum(int a, int b, int c) {
		
		int minimum = a;
		if(minimum>=b){
			minimum =b;
		}
		
		if(minimum>=c) {
			minimum =c;
		}
		
		return minimum;
	}
	
	public static void main(String[] args) {
		
		System.out.println(minimum(1,2,3));
		System.out.println(minimum(7,2,3));
		System.out.println(minimum(3,2,3));
		System.out.println(minimum(1,0,3));
		
	}
}
