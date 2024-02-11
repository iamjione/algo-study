class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        int min, max;
        if(a<=b){
            min = a;
            max = b;
        }else{
            min = b;
            max = a;
        }
        
        answer = (long)(((double)(max + min) / 2) * (max - min + 1));
        return answer;
    }
}