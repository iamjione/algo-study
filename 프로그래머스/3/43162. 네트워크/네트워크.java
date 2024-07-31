class Solution {
    
    int[][] computer;
    boolean[] visited;
    int answer = 0;
    
    public int solution(int n, int[][] computers) {
        computer = computers;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]) answer++;
            
            dfs(i, n);
        }
        
        return answer;
    }
    
    void dfs(int idx, int n){
        visited[idx] = true;
        
        for(int i=0; i<n; i++){
            // 자기 자신이 아니고 연결되어 있으며 아직 방문하지 않은 곳이면 방문
            if(idx != i && computer[idx][i] == 1 && !visited[i]) {
                
                dfs(i, n);
            }
        }
    }
}