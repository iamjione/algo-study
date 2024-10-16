class Solution {
    
    static int answer = 0;
    static int[][] d;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        d = dungeons;
        visited = new boolean[d.length];
        
        explore(k, 0);
        
        return answer;
    }
    
    void explore(int curr, int cnt){
        for(int i=0; i<d.length; i++){
            if(visited[i] || curr < d[i][0]) continue;
            
            visited[i] = true;
            answer = Math.max(answer, cnt+1);
            explore(curr-d[i][1], cnt+1);
            visited[i] = false;
        }
    }
}