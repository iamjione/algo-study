import java.util.*;

class Solution {
    
    // 가로나 세로 길이가 1인 직사각형 내부 표시해주기 위해 크기 2배로 설정
    int[][] map = new int[102][102];
    
    int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        // map에 직사각형 내부 -1로 표시
        for(int[] rec : rectangle){
            for(int i=rec[0]*2+1; i<rec[2]*2; i++){
                for(int j=rec[1]*2+1; j<rec[3]*2; j++){
                    map[i][j] = -1;
                }
            }
        }
        
        bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        
        // 시작점의 방문순서 1이니까 1빼주고 map 2배했으니까 다시 2로 나눠줌
        return (map[itemX*2][itemY*2]-1)/2;
    }
    
    private void bfs(int characterX, int characterY, int itemX, int itemY){
        
        Queue<Point> q = new ArrayDeque<>();
        
        // 출발점 큐에 저장 & map에 방문 순서 표시
        q.offer(new Point(characterX, characterY));
        map[characterX][characterY] = 1;
        
        while(!q.isEmpty()){
            int r = q.peek().r;
            int c = q.peek().c;
            q.poll();
            
            for(int i=0; i<4; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];

                // 사각형 내부거나 이미 방문한 곳이면 컨티뉴
                if(map[nr][nc] != 0) continue;
                
                // 테두리가 아닌 곳이면 컨티뉴
                if(!isValid(nr, nc)) {
                    map[nr][nc] = -2; // 중복검사 막기 위해 -2 저장
                    continue;
                }
                
                // 이동할 곳 큐에 넣고 방문 순서 map에 저장
                q.offer(new Point(nr, nc));
                map[nr][nc] = map[r][c] + 1;
                
                // 아이템이 있는 곳에 도착했으면 리턴
                if(nr==itemX && nc==itemY) return;
            }
        }
    }
    
    private boolean isValid(int r, int c){
        // 8방탐색해서 주위에 -1인 곳 있으면 테두리
        for(int i=0; i<8; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            
            // 배열 범위 벗어나면 컨티뉴
            if(nr<0 || nr>101 || nc<0 || nc>101) continue;
            
            if(map[nr][nc]==-1) return true;
        }
        
        return false;
    }
    
    class Point{
        int r;
        int c;
        
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}