package com.practice.search;

import java.util.Arrays;

public class CustomBinarySearch {

	public static final int maxSize = 10;

	public static void main( String[] args ) {
		int arr[] = new int[] { 16, 18, 15, 15, 10, 11, 19, 15, 10, 11 };
		Arrays.parallelSort( arr );
		System.out.println( binarySearch( arr, 16 ) );
	}

	public static boolean binarySearch( int[] arr, int value ) {

		/*		int left = 0 ;
				int right  = arr.length-1;
				boolean found = false;
				while (left<=right) {
					int midIndex = left + ((right-left))/2;
					
					if(arr[midIndex]==value) {
						found = true;
						break;
					}else if(arr[midIndex]>value) {
						right = midIndex-1;
					}else {
						left= midIndex+1;
					}
				}
				return found;*/

		return binarySearchRecursive( arr, 0, arr.length - 1, value );

	}

	private static boolean binarySearchRecursive( int[] p_arr, int left, int right, int p_value ) {
		boolean found = false;
		if ( left > right ) {
			return false;
		}
		int midIndex = ( left + right ) / 2;
		if ( p_arr[midIndex] == p_value ) {
			return true;
		}
		if ( p_arr[midIndex] > p_value ) {
			return binarySearchRecursive( p_arr, left, midIndex - 1, p_value );
		}
		else {
			return binarySearchRecursive( p_arr, midIndex + 1, right, p_value );
		}
	}

}
