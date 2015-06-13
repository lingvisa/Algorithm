package com.martin.sort;

import java.util.Arrays;

public class InsertionSort {

	/*
	 * 
	 * Algorithm: for i=[1, length-1], j=i-1; compare array[j] & array[j+1] and swap if array[j] > array[j+1]; 
	 * 
	 * */
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
	
	
	public static void main(String[] args) {
		
		testInsertion();
		
	}
}
