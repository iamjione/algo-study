import java.util.*;

class Solution {
    
    public int solution(int sticker[]) {
        if(sticker.length==1) return sticker[0];
        if(sticker.length==2) return Math.max(sticker[0], sticker[1]);
        
        return Math.max(findMax(sticker, 0), findMax(sticker, 1));
    }
    
    private int findMax(int[] sticker, int start){
        int len = sticker.length-1;
        
        int[] dp = new int[len];
        dp[0] = sticker[start];
        dp[1] = Math.max(sticker[start], sticker[start+1]);
        
        for(int i=2; i<len; i++){
            dp[i] = Math.max(dp[i-2]+sticker[i+start], dp[i-1]);
        }
        
        return dp[len-1];
    }
}