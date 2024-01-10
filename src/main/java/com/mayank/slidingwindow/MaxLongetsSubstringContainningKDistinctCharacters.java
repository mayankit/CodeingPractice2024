package com.mayank.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 Find the longest substring of a string containing `k` distinct characters

 Given a string and a positive number k, find the longest substring of the string containing k distinct characters. If k is more than the total number of distinct characters in the string, return the whole string.

 The problem differs from the problem of finding the longest subsequence with k distinct characters. Unlike subsequences, substrings are required to occupy consecutive positions within the original string.



 For example, consider string abcbdbdbbdcdabd.
 For k = 2, o/p is ‘bdbdbbd’
 For k = 3, o/p is ‘bcbdbdbbdcd’ For k = 5, o/p is ‘abcbdbdbbdcdabd’
 */
public class MaxLongetsSubstringContainningKDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(solve("abcbdbdbbdcdabd",2));
        System.out.println(solve("abcbdbdbbdcdabd",3));
        System.out.println(solve("abcbdbdbbdcdabd",5));
    }

    private static String solve(String str, int k) {
       if(str == null || str.length() == 0){
           return str;
       }
       Map<Character, Integer> frequency = new HashMap<>();
       Set<Character> window = new HashSet<>();

       int start = 0;
       int end = 0;

       for(int low=0,high=0;high< str.length();high++){

           window.add(str.charAt(high));
           if(frequency.containsKey(str.charAt(high))){
               frequency.put(str.charAt(high), frequency.get(str.charAt(high))+1);
           }else{
               frequency.put(str.charAt(high), 1);
           }

           while(window.size() > k){
               frequency.put(str.charAt(low), frequency.get(str.charAt(low))-1);
               if(frequency.get(str.charAt(low)) == 0){
                   window.remove(str.charAt(low));
               }

               low++;
           }

           if(end-start < high-low){
               end = high;
               start = low;
           }

        }
       return str.substring(start, end+1);
    }
}
