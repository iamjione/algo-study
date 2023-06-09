import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//분기점의 수
		int M = Integer.parseInt(st.nextToken());//분기점을 잇는 길의 수
		
		//0: 적의 시야에 보이지 않는 곳(==갈 수 있는 곳)
		//1: 적의 시야에 보이는 곳(==갈 수 없는 곳)
		//N-1번째는 1이지만 갈 수 있음
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
	
		ArrayList<Node>[] adjList = new ArrayList[N];
		for(int i=0; i<N; i++) adjList[i] = new ArrayList<>();
		
		int a,b,t;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			
			//양방향
			adjList[a].add(new Node(b,t));
			adjList[b].add(new Node(a,t));
		}
		
		//출발점0에서 각 분기점까지의 최소 이동 시간 저장할 배열
		//1 ≤ N ≤ 100,000, 1 ≤ t ≤ 100,000 이기 때문에 int형 범위 초과
		long[] minTime = new long[N];
		Arrays.fill(minTime, Long.MAX_VALUE);//최소값 갱신하기 위해 큰 값으로 초기화
		boolean[] visited = new boolean[N];//경유지로 고려됐는지 여부
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		minTime[0] = 0;//출발점에서 출발점까지 이동시간 0
		pq.add(new Node(0,0));//출발점 우선순위큐에 넣음
		
		while(!pq.isEmpty()) {
			//1. 방문하지 않은 가장 가까운 분기점 선택
			Node curr = pq.poll();
			int idx = curr.idx;
			long min = curr.time;
			
			if(visited[idx] || arr[idx]==1) continue;//이미 방문했던 곳이거나 갈 수 없는 곳이면 컨티뉴
			else visited[idx] = true;//방문체크
			
			//2. 1번에서 선택된 분기점을 경유지로 해서 갈 수 있는 다른 미방문 분기점의 최단 소요 시간 갱신
			for(Node n : adjList[idx]) {
				//이미 방문했거나 갈 수 없는 곳이면 컨티뉴
				if(visited[n.idx] || arr[idx]==1) continue;
				
				//최단 시간 갱신 후 pq에 넣음
				minTime[n.idx] = Math.min(minTime[n.idx], min+n.time);
				pq.add(new Node(n.idx, minTime[n.idx]));
			}
		}
		
		if(minTime[N-1]==Long.MAX_VALUE) System.out.println(-1);//상대 넥서스 까지 갈 수 없는 경우 -1 출력
		else System.out.println(minTime[N-1]);
	}


	private static class Node implements Comparable<Node>{
		int idx;
		long time;

		public Node(int idx, long time) {
			this.idx = idx;
			this.time = time;
		}
		//시간 기준으로 오름차순 정렬
		@Override
		public int compareTo(Node o) {
			return Long.compare(this.time, o.time);
		}
		
	}
}