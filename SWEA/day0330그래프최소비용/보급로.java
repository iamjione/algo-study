package day0330그래프최소비용;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 보급로 {

	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int[][] arr;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] time;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();//지도 크기
			arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String s = sc.next();
				for(int j=0; j<N; j++) {
					arr[i][j] = s.charAt(j)-'0';
				}
			}
			
			time = new int[N][N];
			for(int i=0; i<N; i++) {
				Arrays.fill(time[i], INF);
			}
			time[0][0] = 0;
			
			visited = new boolean[N][N];
			
			dijkstra(new Node(0,0,arr[0][0]));
			
			System.out.println("#"+tc+" "+time[N-1][N-1]);
		}//tc

	}

	private static void dijkstra(Node node) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(node);
		
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int r = curr.r;
			int c = curr.c;
			visited[r][c] = true;
			
			for(int i=0; i<4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				
				//배열 범위 벗어나면 컨티뉴
				if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
				//이미 방문한 곳이면 컨티뉴
				if(visited[nr][nc]) continue;
				
				time[nr][nc] = Math.min(time[nr][nc], time[r][c]+arr[nr][nc]);
				Node next = new Node(nr,nc,time[nr][nc]);
				pq.add(next);
			}
		}
		
	}
	
	static class Node implements Comparable<Node> {
		int r, c, depth;
		public Node(int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.depth = depth;
		}
		@Override
		public int compareTo(Node o) {
			return this.depth-o.depth;
		}
	}

}