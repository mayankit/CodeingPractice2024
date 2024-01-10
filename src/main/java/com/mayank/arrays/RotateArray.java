package com.mayank.arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        if(k > nums.length){
            k  = k % nums.length ;
        }
        reverse(nums,0, nums.length-1-k) ;
        reverse(nums,nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }

    public void reverse(int[] nums, int start, int end){

        while(start<=end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
