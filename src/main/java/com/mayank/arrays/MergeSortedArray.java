package com.mayank.arrays;

public class MergeSortedArray {
    public static void main(String[] args) {

    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if(nums1.length == 0){
            nums1 = nums2;
            return;
        }

        if(nums2.length == 0){
            return;
        }

        for(int i=0,j=0;i<nums1.length;i++){

            // if left value greater than right value
            if(nums1[i] > nums2[j]){
                int temp = nums2[j];
                nums2[j] = nums1[i];
                nums1[i] = temp;
            }

            if(i >= m){
                nums1[i] = nums2[j];
                j++;
            }

        }
    }
}
