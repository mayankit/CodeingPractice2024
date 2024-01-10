package com.mayank;

import sun.awt.image.ImageWatched;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        List<String> wordlist = new ArrayList<>();
        wordlist.add("cats");
        wordlist.add("on");
        wordlist.add("cat");
        System.out.println(wb.wordBreak("catson", wordlist));
    }
    
    public boolean wordBreak(String s, List<String> wordDict){
        Set<String> words = new HashSet<>();
        
        for(String word: wordDict){
            words.add(word);
        }

        boolean[] seen = new boolean[s.length() +1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while(!queue.isEmpty()){

            int start = queue.remove();

            if(start == s.length()) return true;

            for(int end = start+1; end<= s.length();end++){

                if(seen[end]){
                    continue;
                }

                if(wordDict.contains(s.substring(start,end))){
                    seen[end] =true;
                    queue.add(end);
                }
            }
        }
        return false;
    }
}
