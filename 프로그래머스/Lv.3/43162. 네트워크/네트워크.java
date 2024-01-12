class Solution {
    
    static boolean[] visited;
    static int[][] arr;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        arr = computers;
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                answer++;
                dfs(i);  
            }
        }
        
        return answer;
    }
    
    private static void dfs(int num){
        visited[num] = true;
        
        for(int i=0; i<arr.length; i++){
            if(i==num) continue;
            
            if(arr[num][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
        
        return;
    }
}