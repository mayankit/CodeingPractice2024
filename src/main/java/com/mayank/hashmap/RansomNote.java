package com.mayank.hashmap;
import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args) {
        RansomNote rn = new RansomNote();
        System.out.println( rn.canConstruct("dehifb", "hhjdgjbhahaagihhhhhajjibjffhijehda"));

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> countMap = new HashMap<>();

        for(int i=0;i< magazine.length();i++){

            int count = countMap.getOrDefault(magazine.charAt(i), 0);
            count++;
            countMap.put(magazine.charAt(i), count);
        }

        for(int i=0;i<ransomNote.length();i++){

            int count = countMap.getOrDefault(ransomNote.charAt(i), 0);

            if(count == 0) return false;

            count--;
            countMap.put(ransomNote.charAt(i), count);
        }

        return true;
    }
}
