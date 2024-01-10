package com.mayank.slidingwindow;

public class LongestAlternatingSubArray {

    public static void main(String[] args) {
        LongestAlternatingSubArray la = new LongestAlternatingSubArray();

        la.longestAlternatingSubarray(new int[]{4}, 1);
    }
    public int longestAlternatingSubarray(int[] nums, int threshold) {

        if (nums.length == 1 && nums[0] <= threshold && nums[0] % 2 == 0) {
            return 1;
        }

        int start = 0;
        int end = 0;
        int low = 0;
        int high = 0;
        while (low <= high && low < nums.length && high < nums.length) {

            if (!satisfyCondition(nums, low, high, threshold)) {
                low = high;
            }

            if (end - start < high - low) {
                start = low;
                end = high;
            }
            high++;
        }

        return end - start;
    }

    public boolean satisfyCondition(int[] nums, int low, int high, int threshold){

        if(low == high){
            return nums[low] % 2 == 0 && nums[low] <= threshold;
        } else{
            return nums[low] % 2 == 0 && nums[high-1]  %2 != nums[high] %2  && nums[high] <= threshold;
        }

    }
}
