class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        long min, max;
        if(a<=b){
            min = a;
            max = b;
        }else{
            min = b;
            max = a;
        }
        
        answer = (max + min) * (max - min + 1) / 2 ;
        return answer;
    }
}