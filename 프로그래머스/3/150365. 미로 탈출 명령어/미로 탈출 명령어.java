import java.util.*;

class Solution {
    
    LinkedList<Integer> list = new LinkedList<>();
    String answer = "";
    // dlru 순으로 탐색
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        escape(n, m, x, y, r, c, k);
        
        if(answer.equals("")) return "impossible";
        return answer;
    }
    
    void escape(int n, int m, int x, int y, int r, int c, int k){
        
        // 이미 탈출했으면 리턴
        if(!answer.equals("")) return;

        // k번 이동해서 r,c에 도착한 경우 answer 갱신하고 리턴
        if(x==r && y==c && k==0){
            StringBuilder sb = new StringBuilder();
            char[] d = {'d', 'l', 'r', 'u'};
            
            for(int idx : list){
                sb.append(d[idx]);
            }
            
            answer = sb.toString();
            
            return;
        }
        
        int nx, ny;
        for(int i=0; i<4; i++){
            nx = x+dx[i];
            ny = y+dy[i];
            
            // 범위 벗어난 경우 컨티뉴
            if(nx<=0 || nx>n || ny<=0 || ny>m) continue;
            
            // (nx, ny)에서 (r,c)로 k번만에 이동하지 못하는 경우 컨티뉴
            int dis = Math.abs(nx-r)+Math.abs(ny-c); // 남은 거리
            if(dis>k) continue;
            if(dis%2 != (k-1)%2) continue;
            
            list.add(i);
            escape(n, m, nx, ny, r, c, k-1);
            list.removeLast();
        }
    }
}