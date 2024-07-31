class Solution {

    int answer = 0;
    int[] number;
    
    public int solution(int[] numbers, int target) {
        number = numbers;
        
        recur(0, 0, target);
        
        return answer;
    }
    
    void recur(int idx, int num, int target){
        if(idx == number.length){
            if(num == target) answer++;
            
            return;
        }
        
        recur(idx+1, num+number[idx], target);
        recur(idx+1, num-number[idx], target);
        
    }
}