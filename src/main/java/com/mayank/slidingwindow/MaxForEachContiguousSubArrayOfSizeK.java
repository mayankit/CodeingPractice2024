package com.mayank.slidingwindow;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array arr of size N and an integer K, the task is to find the maximum for each and every contiguous subarray of size K.
 */
public class MaxForEachContiguousSubArrayOfSizeK {
    public static void main(String[] args) {
        int arr[] = {1,2,3,1,4,5,2,3,6};
        int k = 3;
        System.out.println(getArrayListOfMaxInKSubarray(arr, k));

    }

    private static List<Integer> getArrayListOfMaxInKSubarray(int[] arr, int k) {
        List<Integer> results = new ArrayList<>();
        if(k == 1) return Arrays.stream(arr).boxed().collect(Collectors.toList());

        int start = 0;
        int end = k-1;
        int temp = start;
        int max = arr[end];

        while(end < arr.length){
            if(arr[start]> max){
                max = arr[start];
            }

            start++;

            if(start == end && start != arr.length){
                results.add(max);
                end++;
                start = temp++;

                if(start< arr.length){
                    max = arr[start];
                }
            }
        }

        return results;
    }
}
