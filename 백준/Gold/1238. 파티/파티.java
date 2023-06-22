import java.util.*;

public class Main {
	/*
	 * [다익스트라 2번만 써서 푸는 방법]
	 * 간선 방향 반대로 입력받아서 X에서 출발하는 다익스트라 실행하면
	 * 각 마을에서 X마을로 가는 최단 시간 구할 수 있음
	 */
	static int N,X;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//마을 수
		int M = sc.nextInt();//도로 수
		X = sc.nextInt();//파티여는 마을 번호
		
		ArrayList<Node>[] adjList = new ArrayList[N+1];//간선 방향 원래대로 저장할 인접리스트
		ArrayList<Node>[] reverseAdjList = new ArrayList[N+1];//간선 방향 반대로 저장할 인접 리스트
		for(int i=1; i<N+1; i++) {
			adjList[i] = new ArrayList<>();
			reverseAdjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			int u = sc.nextInt();//시작점
			int v = sc.nextInt();//끝점
			int w = sc.nextInt();//소요 시간

			adjList[u].add(new Node(v,w));
			reverseAdjList[v].add(new Node(u,w));
		}
		
		//X마을에서 모든 마을까지의 최소 소요 시간 구하기
		int[] time1 = dijkstra(adjList);
		
		//모든 마을에서 X마을까지의 최소 소요 시간 구하기
		int[] time2 = dijkstra(reverseAdjList);
		
		int max = 0;//최대 소요시간
		for(int i=1; i<N+1; i++) max = Math.max(max, time1[i]+time2[i]);
		System.out.println(max);
	}
	
	private static int[] dijkstra(ArrayList<Node>[] list) {
		int[] time = new int[N+1];
		Arrays.fill(time, Integer.MAX_VALUE);//최대값으로 초기화
		time[X] = 0;//출발점에서 출발점까지 소요시간==0
		
		boolean[] visited = new boolean[N+1];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(X,0));
		
		while(!pq.isEmpty()) {
			int curr = pq.poll().v;
			
			if(visited[curr]) continue;
			
			visited[curr] = true;
			for(Node n : list[curr]) {
				int next = n.v;
				if(visited[next]) continue;
				time[next] = Math.min(time[next], time[curr]+n.w);
				pq.add(new Node(next, time[next]));
			}
		}
		
		return time;
	}


	private static class Node implements Comparable<Node>{
		int v,w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		//소요시간순으로 정렬
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
		
	}

}