class Solution {
    
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]) {
                answer++;
                visited[i] = true;
                DFS(computers, i);
            }
        }
        
        return answer;
    }
    
    // idx번째 컴퓨터랑 연결된 다른 컴퓨터 방문 처리 하기
    void DFS(int[][] computers, int idx){
        for(int i=0; i<computers.length; i++){
            // 나 자신이거나 연결 안된 컴퓨터거나 이미 방문한 컴퓨터면 넘어가기
            if(i == idx || computers[idx][i] == 0 || visited[i]) continue;
            
            visited[i] = true;
            DFS(computers, i);
        }
    }
}