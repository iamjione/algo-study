class Solution {
    int N; // 던전 수
    boolean[] visited; // 방문 체크 배열
    int max = 0; // 탐험할 수 있는 최대 던전 수
    int[][] d;
    
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        visited = new boolean[N];
        d = dungeons;
        
        explore(k, 0);
        
        return max;
    }
    
    // k: 현재 피로도, cnt: 탐험한 던전 수
    void explore(int k, int cnt){
        if(cnt>max) max = cnt;
        
        for(int i=0; i<N; i++){
            //  이미 방문한 곳이거나 최소 필요 피로도 보다 현재 피로도가 작으면 건너뛰기
            if(visited[i] || d[i][0]>k) continue;
            
            // 탐험할 수 있는 곳이면 탐험하기
            visited[i] = true;
            explore(k-d[i][1], cnt+1);
            visited[i] = false; // 원상복구
        }
    }
}