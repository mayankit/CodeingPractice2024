package com.mayank.slidingwindow;

public class JumpGameVII {

    public static void main(String[] args) {
        JumpGameVII jg =new JumpGameVII();
        jg.canReach("0000000000", 2,5);
    }
    public boolean canReach(String s, int minJump, int maxJump) {

        int i=0;

        while( i< s.length()-1){

            int j = i+ minJump;
            boolean isValid = false;

            while(j< s.length() && j<= i+ maxJump){

                if(s.charAt(j) == '0'){
                    i = j;
                    isValid = true;
                    break;
                }
                j++;
            }

            if(!isValid){
                return false;
            }
        }

        return true;
    }
}
