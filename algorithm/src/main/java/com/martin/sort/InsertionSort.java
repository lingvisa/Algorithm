package com.martin.sort;

import java.util.Arrays;

/* Author: Congmin Min
 * Date:   06/17/2015
 * 
 * Problem: insertion sort
 * Example: [0,8,9,3, 4, 1]
 * 
 * Algorithm: for i=[1, length-1], j=i-1; compare array[j] & array[j+1] and swap if array[j] > array[j+1];
 *  
 * 
 * */


public class InsertionSort {

	static void insertion(int[] array) {
		
		for(int i=1; i<array.length; i++) {
			for(int j=i-1; j>=0; j--) {
				if(array[j]>array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}else{
					break;
				}
			}
		}
	}
	
	// slighly optmized version, without multiple swaps, only movement in the while loop
	static void insertion2(int[] array) {

		for(int i=1; i<array.length; i++) {
			int current = array[i];
			int j = i;
			while(j>0 && array[j-1]>current) {				
				array[j] = array[j-1]; 
				j--;
			}
			array[j] = current;
		}
	}
	
	static void testInsertion() {
		
		int[] array = {0, 9, 3, 1, 6};
		insertion(array);
		int[] a = {0,1,3,6,9};
		assert Arrays.equals(array, a);
		
		int[] array1 = {0, 1, 3, 6, 9};
		insertion(array1);
		assert Arrays.equals(array1, a);
		
		int[] array2 = {0, 1, 3, 3, 9};
		int[] a2 = {0,1,3,3,9};
		insertion(array1);
		assert Arrays.equals(array2, a2);
		
		System.out.println("Test testInsertion() successful!");
		
	}

	static void testInsertion2() {

		int[] array = {0, 9, 3, 1, 6};
		insertion2(array);
		int[] a = {0,1,3,6,9};
		assert Arrays.equals(array, a);

		int[] array1 = {0, 1, 3, 6, 9};
		insertion2(array1);
		assert Arrays.equals(array1, a);

		int[] array2 = {0, 1, 3, 3, 9};
		int[] a2 = {0,1,3,3,9};
		insertion2(array1);
		assert Arrays.equals(array2, a2);

		System.out.println("Test testInsertion2() successful!");

	}

	public static void main(String[] args) {
		
		testInsertion();

		testInsertion2();
		
	}
}
