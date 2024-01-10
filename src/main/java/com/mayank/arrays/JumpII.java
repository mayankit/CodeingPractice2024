package com.mayank.arrays;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 *     0 <= j <= nums[i] and
 *     i + j < n
 *
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 */
public class JumpII {
    public static void main(String[] args) {
        JumpII jumpII = new JumpII();
        jumpII.jump1(new int[]{2, 3, 1, 1, 4});
    }
    public int jump(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> indexSet = new HashSet<>();
        int [] levelArray = new int[nums.length];

        queue.add(0);
        indexSet.add(0);

        while(!queue.isEmpty()){
            Integer index = queue.remove();

            if(index == nums.length-1) return levelArray[nums.length-1];

            for(int i=1;i<= nums[index];i++){
                if(!indexSet.contains(index+i) && (index + i) <= nums.length-1){
                    indexSet.add(index+i);
                    queue.add(index + i);
                    levelArray[index+i] = levelArray[index] +1;
                }
            }
        }
        return -1;
    }

    public int jump1(int[] nums) {
        int farthest = 0;
        int count = 0;
        int end = 0;

        for(int i=0;i<nums.length-1;++i){

            farthest = Math.max(farthest, i + nums[i]);

            if(farthest >= nums.length-1){
                count++;
                break;
            }

            if(i == end){
                count++;     //increase the level
                end = farthest;
            }
        }
        return count;
    }

}
