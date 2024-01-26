import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // 인접 리스트에 간선 정보 저장
        ArrayList<Edge>[] adjList = new ArrayList[n];
        
        for(int i=0; i<n; i++) adjList[i] = new ArrayList<>();
        for(int i=0; i<costs.length; i++){
            int start = costs[i][0];
            int end = costs[i][1];
            int cost = costs[i][2];
            
            adjList[start].add(new Edge(end, cost));
            adjList[end].add(new Edge(start, cost));
        }
        
        boolean[] visited = new boolean[n]; // 방문 체크 배열
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        pq.add(new Edge(0,0)); // 0번 섬을 시작 정점으로 함
        
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            
            if(visited[curr.island]) continue;
            
            visited[curr.island] = true;
            answer += curr.cost;
            
            for(Edge next : adjList[curr.island]){
                if(visited[next.island]) continue;
            
                pq.add(next);
            }
        }
        
        
        
        return answer;
    }
    
    class Edge implements Comparable<Edge>{
        int island, cost;
        
        public Edge(int island, int cost){
            this.island = island;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
}