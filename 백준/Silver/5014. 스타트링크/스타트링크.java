import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int F = sc.nextInt(); // 전체 층
		int S = sc.nextInt(); // 현재 층
		int G = sc.nextInt(); // 스타트링크 층
		int U = sc.nextInt();
		int D = sc.nextInt();
		
		if(S==G) {
			System.out.println(0);
			return;
		}
		
		boolean[] visited = new boolean[F+1];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(S, 0));
		visited[S] = true;
		
		int ans = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			int nextU = curr.floor+U;
			int nextD = curr.floor-D;
			
			if(nextU == G || nextD == G) {
				ans = curr.depth+1;	
				break;
			}
			
			if(nextU <= F && !visited[nextU]) {
				pq.offer(new Node(nextU, curr.depth+1));
				visited[nextU] = true;
			}
			
			if(nextD > 0 && !visited[nextD]) {
				pq.offer(new Node(nextD, curr.depth+1));
				visited[nextD] = true;
			}
		}
		
		System.out.println(ans==0?"use the stairs":ans);
		
	}
	
	private static class Node implements Comparable<Node>{
		int floor, depth;
		
		public Node(int floor, int depth) {
			this.floor = floor;
			this.depth = depth;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.depth - o.depth;
		}
	}

}