import java.util.*;

public class Main {
	
	static int N, X;
	static ArrayList<Node>[] adjList;
	static int[] time;//최소 소요 시간 저장할 배열
	static boolean[] visited;//방문체크 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//마을 수
		int M = sc.nextInt();//도로 수
		X = sc.nextInt();//파티여는 마을 번호
		
		adjList = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) adjList[i] = new ArrayList<>();
		for(int i=0; i<M; i++) {
			int u = sc.nextInt();//시작점
			int v = sc.nextInt();//끝점
			int w = sc.nextInt();//소요 시간
			//단방향 도로
			adjList[u].add(new Node(v,w));
		}
		
		//X마을에서 모든 마을까지의 최소 소요 시간 구하기
		time = new int[N+1];
		Arrays.fill(time, Integer.MAX_VALUE);//최대값으로 초기화
		time[X] = 0;//출발점에서 출발점까지 소요시간==0		
		visited = new boolean[N+1];
		dijkstra();
		int[] minTime = new int[N+1];
		minTime = time.clone();//X마을에서 모든 마을까지 걸린 최소시간 minTime에 저장
		
		//모든 마을에서 X마을까지의 최소 소요 시간 구하기
		for(int i=1; i<N+1; i++) {
			Arrays.fill(time, Integer.MAX_VALUE);
			time[i] = 0;
			visited = new boolean[N+1];
			dijkstra(i);
			minTime[i] += time[X];//X마을까지 걸린 시간 minTime에 더하기
		}
		
		int max = 0;//최대 소요시간
		for(int i=1; i<N+1; i++) max = Math.max(max, minTime[i]);
		System.out.println(max);
	}
	
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(X,0));
		
		while(!pq.isEmpty()) {
			int curr = pq.poll().v;
			
			if(visited[curr]) continue;
			
			visited[curr] = true;
			for(Node n : adjList[curr]) {
				int next = n.v;
				if(visited[next]) continue;
				time[next] = Math.min(time[next], time[curr]+n.w);
				pq.add(new Node(next, time[next]));
			}
		}
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			int curr = pq.poll().v;
			
			if(curr==X) return;//X마을에 도착했으면 끝내기
			if(visited[curr]) continue;
			
			visited[curr] = true;
			for(Node n : adjList[curr]) {
				int next = n.v;
				if(visited[next]) continue;
				time[next] = Math.min(time[next], time[curr]+n.w);
				pq.add(new Node(next, time[next]));
			}
		}
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