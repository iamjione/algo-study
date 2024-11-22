import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {	

	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점의 개수
		int E = sc.nextInt(); // 간선의 개수
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(int i=0; i<E; i++) {
			pq.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		p = new int[V+1];
		
		// make set
		for(int i=1; i<V+1; i++) {
			p[i] = i;
		}
				
		// 간선 V-1개 뽑기 
		int ans = 0;
		int cnt = 0;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			int px = findset(e.a);
			int py = findset(e.b);
					
			//부모가 다르면 연결해주기
			if(px!=py) {
				union(px, py);
				ans += e.w;
				cnt++;
			}
			
			if(cnt == V-1) break;
		}
				
		System.out.println(ans);
	}

	private static int findset(int x) {
		if(x != p[x]) p[x] = findset(p[x]);
		return p[x];
	}

	private static void union(int px, int py) {
		if(py>px) p[px] = findset(py);
		
		else p[py] = findset(px);
	}

	
	private static class Edge implements Comparable<Edge>{
		int a, b, w;
		
		public Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}

}