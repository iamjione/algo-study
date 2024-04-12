import java.util.*;

class Solution {
    
    ArrayList<Integer>[] adjList;
    int answer = Integer.MAX_VALUE;
    boolean[] visited;
    int N;
    
    public int solution(int n, int[][] wires) {
        N = n;
        
        // 인접 행렬 리스트에 전선 정보 저장하기
        adjList = new ArrayList[n+1];
        for(int i=1; i<=n; i++) adjList[i] = new ArrayList<>();
        
        for(int[] wire : wires){
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }
        
        // 전선 하나씩 끊으면서 전력망의 송전탑 수 비교하기
        for(int[] wire : wires){
            cut(wire);
            compare(wire);
            connect(wire);
        }
        
        return answer;
    }
    
    // 전선 끊기
    private void cut(int[] wire){
        adjList[wire[0]].remove(Integer.valueOf(wire[1]));
        adjList[wire[1]].remove(Integer.valueOf(wire[0]));
    }
    
    // 전선 연결하기
    private void connect(int[] wire){
        adjList[wire[0]].add(wire[1]);
        adjList[wire[1]].add(wire[0]);
    }
    
    // 두 송전탑과 연결된 송전탑의 개수 비교해서 answer 갱신
    private void compare(int[] wire){
        visited = new boolean[N+1];
        dfs(wire[0], 1);
        int a = countVisited();
        
        visited = new boolean[N+1];
        dfs(wire[1], 1);
        int b = countVisited();
        answer = Math.min(answer, Math.abs(a-b));
    }
    
    private void dfs(int i, int cnt){
        visited[i] = true;
        
        for(int n : adjList[i]){
            if(!visited[n]){
                dfs(n, cnt+1);
            }
        }
    }
    
    // 방문한(연결되어있는) 송전탑 개수 새기
    private int countVisited(){
        int cnt = 0;
        for(boolean v : visited){
            if(v) cnt++;
        }
        
        return cnt;
    }
}