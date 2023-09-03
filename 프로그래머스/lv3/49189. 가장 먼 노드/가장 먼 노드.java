import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] adjList = new ArrayList[n+1];
		for(int i = 0 ; i<=n; i++) adjList[i] = new ArrayList<>();
		
		for (int i = 0; i < edge.length; i++) {
			adjList[edge[i][0]].add(edge[i][1]);
			adjList[edge[i][1]].add(edge[i][0]);
		}
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        //bfs
        Queue<Integer> q = new ArrayDeque<>();
        
		q.add(1);
        dist[1] = 0;

		while(!q.isEmpty()) {
			int curr = q.poll();
            
            for(int next :adjList[curr]){
                if(dist[next] == Integer.MAX_VALUE){
                    q.add(next);
                    dist[next] = dist[curr]+1;
                }
            }
        }
		
        int max = 0;
        for(int i=1; i<=n; i++){
            if(dist[i]>max && dist[i] != Integer.MAX_VALUE) {
                answer = 1;
                max = dist[i];
            } else if(dist[i] == max) {
                answer++;
            }
        }
        return answer;
    }
}