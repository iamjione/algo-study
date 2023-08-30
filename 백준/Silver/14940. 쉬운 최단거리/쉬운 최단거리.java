import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int n, m;
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		Point goal = new Point(0, 0);
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr[i][j] = sc.nextInt();
				
				//목표지점 나오면 목표지점 좌표 저장
				if(arr[i][j] == 2) {
					goal.r = i;
					goal.c = j;
				}
			}
		}
		
		bfs(goal);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j] && arr[i][j]!=0) {
					sb.append(-1+" ");
				}else {
					sb.append(arr[i][j]+" ");					
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	private static void bfs(Point goal) {
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};

		Queue<Point> q = new ArrayDeque<>();
		
		q.add(goal);
		visited[goal.r][goal.c] = true;
		arr[goal.r][goal.c] = 0;
		
		while(!q.isEmpty()) {
			Point curr = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = curr.r+dr[i];
				int nc = curr.c+dc[i];
				
				//배열 벗어나면 컨티뉴
				if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
				//방문 불가능한 곳이거나 이미 방문한 곳이면 컨티뉴
				if(arr[nr][nc] == 0 || visited[nr][nc]) continue;
				
				q.add(new Point(nr, nc));
				arr[nr][nc] = arr[curr.r][curr.c] + 1;
				visited[nr][nc] = true;
			}
			
		}
	}
	
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

}