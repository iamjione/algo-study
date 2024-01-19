import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer =  20000001;
        
        
		List<Node>[] adjList = new ArrayList[n+1];//인접리스트 
		for(int i = 1 ; i<=n; i++) {
			adjList[i] = new ArrayList<>();
		}
		
        // 인접리스트에 비용 정보 저장
		for(int[] fare : fares) {
			int start = fare[0];
			int end = fare[1];
			int weight = fare[2];
			
			adjList[start].add(new Node(end, weight));
			adjList[end].add(new Node(start, weight));
		}
        
        // s, a, b점을 시작점으로 하는 다익스트라 실행
        int[] d1 = dijkstra(n, s, adjList);
        int[] d2 = dijkstra(n, a, adjList);
        int[] d3 = dijkstra(n, b, adjList);
        
        // 어떤 점(i)을 경유해야 최소 비용인지 찾기 
        for(int i = 1; i <= n ; i ++) {
            answer = Math.min(answer, d1[i] + d2[i] + d3[i]);
        }
        
        return answer;
    }
    
    private int[] dijkstra(int n, int start, List<Node>[] adjList){
        int[] d = new int[n+1]; // 각 정점까지의 최소 비용 저장할 배열
        boolean[] visited = new boolean[n+1]; // 방문 체크 배열
        
        Arrays.fill(d, 1000000); // 배열의 값을 비용의 최대값보다 큰 값으로 초기화
        d[start] = 0; // 시작정점까지의 비용 0
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0)); // 시작점 우선순위 큐에 넣기

        while(!pq.isEmpty()){
            int curr = pq.poll().v;//현재 탐색 정점

            if(visited[curr]) continue;//방문한 곳이면 컨티뉴
            
            visited[curr] = true;//방문 표시해주기
            
            //현재 탐색 정점의 인접 정접 중 방문하지 않은 곳있으면 최소 비용 갱신
            for(Node node : adjList[curr]){
                int next = node.v;//curr의 인접 정점
                
                if(visited[next]) continue;//이미 방문한 곳이면 컨티뉴
                
                //기존 비용과 curr를 경유해서 오는 경우 비교해서 최소 비용 갱신
                d[next] = Math.min(d[next], d[curr]+node.w);
                pq.add(new Node(next,d[next]));
            }
        }
        return d;
    }
    
    class Node implements Comparable<Node>{
        int v,w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w-o.w;
        }
    }
}