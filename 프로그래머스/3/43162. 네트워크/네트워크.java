class Solution {
    
    int[][] computer;
    boolean[] visited;
    int answer = 0;
    
    public int solution(int n, int[][] computers) {
        computer = computers;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]) answer++;
            
            bfs(i, n);
        }
        
        return answer;
    }
    
    void bfs(int idx, int n){
        for(int i=0; i<n; i++){
            if(computer[idx][i] == 1 && !visited[i]) {
                visited[i] = true;
                
                if(idx==i) continue;
                
                bfs(i, n);
            }
        }
    }
}