import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        
        // 인접행렬리스트에 도로 정보 저장
        List<Edge>[] adjList = new ArrayList[N+1];
        for(int i=1; i<=N; i++) adjList[i] = new ArrayList<>();
        
        for(int[] r :road){
            adjList[r[0]].add(new Edge(r[1], r[2]));
            adjList[r[1]].add(new Edge(r[0], r[2]));
        }

        // 다익스트라
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        boolean[] visited = new boolean[N+1];
        
        int answer = 0;
        
        // 1번 마을에서 출발
        distance[1] = 0;
        pq.add(new Edge(1, 0));
        
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            
            // 걸리는 시간이 K 이상이면 뒤에 더 안봐도 됨
            if(distance[curr.town]>K) break;
            
            // 이미 방문한 곳이면 컨티뉴
            if(visited[curr.town]) continue;
            
            visited[curr.town] = true;
            answer++;
            
            for(Edge next : adjList[curr.town]){
                if(distance[next.town] > distance[curr.town]+next.time){
                    distance[next.town] = distance[curr.town]+next.time;
                    pq.offer(new Edge(next.town, distance[next.town]));
                }
            }
        }
        
        
        return answer;
    }
    
    public class Edge implements Comparable<Edge>{
        int town;
        int time;
        
        public Edge(int town, int time){
            this.town = town;
            this.time = time;
        }
        
        // 시간 기준 오름차순 정렬
        @Override
        public int compareTo(Edge o){
            return this.time-o.time;
        }
        
    }
}