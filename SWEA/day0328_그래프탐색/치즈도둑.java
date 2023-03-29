package 그래프탐색;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 치즈도둑 {

	static int N, cnt;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();//한변의 길이
			
			int min=101, max=0;
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j]=sc.nextInt();
					if(arr[i][j]>max) max = arr[i][j];
					if(arr[i][j]<min) min = arr[i][j];
				}
			}
			
			int ans = 1;
			for(int day=min; day<max; day++) {
				//2차원 배열 순회
				cnt = 0;
				visited = new boolean[N][N];
				for(int r=0; r<N; r++) {
					for(int c=0; c<N; c++) {
						//아직 요정이 안먹었고 방문하지 않은 칸이면 bfs 실행
						if(arr[r][c]>day && !visited[r][c]) {
							bfs(r,c,day);
							cnt++;//덩어리 개수 카운트
						}
					}
				}
				if(cnt>ans) ans = cnt;
			}
			System.out.println("#"+tc+" "+ans);
			
		}//tc
	}

	private static void bfs(int r, int c, int day) {
		Queue<int[]> q = new ArrayDeque<>();
		
		int[] rc = {r,c};
		q.add(rc);
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			//큐에서 poll한 값 방문
			r = q.peek()[0];
			c = q.peek()[1];
			q.poll();
			
			//방문한 곳의 상하좌우 탐색
			for(int i=0; i<4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				//배열 범위 벗어나면 컨티뉴
				if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
				//방문한 곳이거나 요정이 먹었으면 컨티뉴
				if(visited[nr][nc] || arr[nr][nc]<=day) continue;
				
			
				int[] nrnc = {nr,nc};
				q.offer(nrnc);
				visited[nr][nc]=true;//방문 표시하기
			}
			
		}
		
	}

}
