import java.util.*;

class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        // map 배열에 물에 잠긴 곳 표시
        int[][] map = new int[n+1][m+1];
        for(int[] p : puddles){
            map[p[1]][p[0]] = -1;
        }
        
        // dp로 최단 경로 개수 찾기
        map[0][1] = 1;
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(map[j][i] == -1) continue;
                
                if(map[j-1][i] == -1) map[j][i] = map[j][i-1];
                else if(map[j][i-1] == -1) map[j][i] = map[j-1][i];
                else map[j][i] = (map[j-1][i] + map[j][i-1])%1000000007;
            }
        }
        
        return map[n][m];
    }
    
}