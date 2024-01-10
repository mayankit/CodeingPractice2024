package com.mayank.slidingwindow;

/**
 *  Given an array of integers of size ‘n’, Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.
 */
public class MaxSumKConsecutiveElements {
    public static void main(String[] args) {
        System.out.println(findMaxKSum(new int[]{100, 200, 300, 400},2));
        System.out.println(findMaxKSum(new int[]{1, 4, 2, 10, 23, 3, 1, 0, 20},4));
        System.out.println(findMaxKSum(new int[]{2,3},43));
    }

    public static int findMaxKSum(int[] arr, int k){
        if(k > arr.length){
            return -1;
        }
        int max = 0;
        int current_sum = 0;
        for(int i=0;i<k;i++){
            current_sum += arr[i];
        }

        if(current_sum > max){
            max = current_sum;
        }

        for(int i=k;i<arr.length;i++){
            current_sum = current_sum + arr[i] - arr[i-k];
            max = Math.max(current_sum, max);
        }

        return max;

    }
}
