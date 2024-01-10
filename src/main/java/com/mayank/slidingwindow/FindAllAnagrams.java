package com.mayank.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class FindAllAnagrams {

    public static void main(String[] args) {
        findAllAnagrams("XYYZXZYZXXYZ","XYZ");
    }

    private static void findAllAnagrams(String mainString, String subString) {

        int subsize = subString.length();
        int mainSize = mainString.length();

        if(subsize > mainSize){
            return;
        }

//This program is not functional because it requires multi set to work correctly
        Set<Character> window = new HashSet<>();
        Set<Character> subStringSet = new HashSet<>();

        for(int i=0;i< subsize;i++){
            subStringSet.add(subString.charAt(i));
        }

        for (int i=0;i<mainSize;i++){

            if(i<subsize){
                window.add(mainString.charAt(i));
            }else{

                if(window.containsAll(subStringSet)){
                    System.out.println("Anagram" + mainString.substring(i-subsize, i) + " present at index " + (i-subsize));
                }

                if(window.contains(mainString.charAt(i-subsize))){
                    window.remove(mainString.charAt(i-subsize));
                }

                window.add(mainString.charAt(i));
            }
        }

    }
}
