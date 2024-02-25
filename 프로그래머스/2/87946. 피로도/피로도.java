class Solution {
    int max = 0; // 탐험할 수 있는 최대 던전 수
    boolean[] visited;
    int[][] d;
    int len;
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        visited = new boolean[len];
        d = dungeons;
        
        explore(k, 0);
        
        return max;
    }
    
    //k: 피로도, cnt: 탐험한 던전 수
    void explore(int k, int cnt){
        // 현재까지 탐험한 던전 수가 max보다 크면 max값 갱신
        if(cnt>max) max = cnt;
        
        for(int i=0; i<len; i++){
            // 아직 i번째 던전을 탐험하지 않았고 
            // 최소 필요 피로도보다 피로도가 많이 남아있다면 탐험
            if(!visited[i] && d[i][0]<=k){
                visited[i] = true;
                explore(k-d[i][1], cnt+1);
                visited[i] = false;
            }
        }
        
        return;
    }
}