class Solution {
    
    static int answer = 0;
    static int[] numbers;
    static int target;
    
    public int solution(int[] arr, int num) {
        numbers = arr;
        target = num;
        
        dfs(0,-1);
        return answer;
    }
    
    private static void dfs(int n, int idx){
        
        idx++;
        
        if(idx == numbers.length){
            if(n == target){
                answer++;
            }
            return;
        }
        
        dfs(n+numbers[idx], idx);
        dfs(n-numbers[idx], idx);
        
    }
}