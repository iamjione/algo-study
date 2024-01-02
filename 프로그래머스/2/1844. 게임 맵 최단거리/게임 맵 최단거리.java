import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        // 이동한 칸 저장할 배열
        int[][] cnt = new int[n][m];
        
        // BFS를 위한 큐
        Queue<Point> q = new ArrayDeque<>();
        
        q.offer(new Point(0,0));// 처음 내 캐릭터의 위치 큐에 넣음
        cnt[0][0] = 1;// 지나간 칸 카운트
        
        // 4방 탐색 델타 값
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,-1,1};
        
        // 큐가 빌 때까지 BFS 실시
        while(!q.isEmpty()){
            int r = q.peek().r;
            int c = q.peek().c;
            q.poll();
            
            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
            
                // map 벗어난 경우
                if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
                // 벽이거나 이미 방문한 길인 경우
                if(maps[nr][nc]==0 || cnt[nr][nc] != 0) continue;
            
                cnt[nr][nc] = cnt[r][c] +1; // 지나간 칸 카운트
                q.offer(new Point(nr,nc)); // 큐에 새로운 탐색 위치 넣음
            }
        }
        if(cnt[n-1][m-1] == 0) return -1;
        else return cnt[n-1][m-1];
    }
    
    private static class Point{
        int r;
        int c;
        
        public Point (int r,int c){
            this.r = r;
            this.c = c;
        }
    }
}