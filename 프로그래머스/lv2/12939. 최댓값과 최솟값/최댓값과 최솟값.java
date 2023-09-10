import java.lang.Integer;

class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            int n = Integer.parseInt(nums[i]);
            if(n > max) max = n;
            if(n < min) min = n;
        }
        String answer = Integer.toString(min)+" "+Integer.toString(max);
        return answer;
    }
}