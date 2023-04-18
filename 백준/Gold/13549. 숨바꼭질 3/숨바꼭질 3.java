import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static boolean[] visited = new boolean[100001];
	static int ans=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//출발 위치
		int K = sc.nextInt();//도착 위치
		
		bfs(N,K);

		System.out.println(ans);
	}

	private static void bfs(int N, int K) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.offer(new Node(N,0));//우선순위큐에 출발 위치 넣기
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int n = curr.n;
			int time = curr.time;
			visited[n]=true;//방문 표시
			
			//K에 도착했을 때 도착까지 걸린 시간 ans에 저장
			if(n==K) {
				ans= time;
				return;
			}
			
			//이동하려는 곳이 범위 내에 있고 아직 방문하지 않은 곳이면 우선순위큐에 넣기
			if(n*2<=100000 && !visited[n*2]) {
				pq.offer(new Node(n*2,time));
			}
			if(n-1>=0 && !visited[n-1]) {
				pq.offer(new Node(n-1,time+1));
			}
			if(n+1<=100000 && !visited[n+1]) {
				pq.offer(new Node(n+1,time+1));
			}
		}
		
	}
	
	static class Node implements Comparable<Node>{
		int n,time;

		public Node(int n, int time) {
			this.n = n;
			this.time = time;
		}

		//시간순 정렬
		@Override
		public int compareTo(Node o) {
			return this.time-o.time;
		}
	}

}