import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class Point{
		int r,c,date;

		public Point(int r, int c, int date) {
			super();
			this.r = r;
			this.c = c;
			this.date = date;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();//상자 가로 칸 수
		int N = sc.nextInt();//상자 세로 칸 수
		
		boolean zero = false;//안 익은 토마토 있는지 체크
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]==0) zero = true;
			}
		}
		
		if(!zero) {
			//안 익은 토마토 없으면 == 다 익었으면 0 출력
			System.out.println(0);
		}else {
			//안 익은 토마토 있을 때
			Queue<Point> q = new ArrayDeque<>();
			
			boolean[][] visited = new boolean[N][M];
			
			int[] dr = {-1,1,0,0};
			int[] dc = {0,0,-1,1};
			
			//익은 토마토 있는 좌표 큐에 넣어줌
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j]==1) {
						q.add(new Point(i,j,0));
						visited[i][j] = true;
					}
				}
			}
			
			int ans = 0;//답
			
			while(!q.isEmpty()) {
				Point p = q.poll();
				int r = p.r;
				int c = p.c;
				
				if(p.date>ans) ans = p.date;
				
				for(int i=0; i<4; i++) {
					int nr = p.r+dr[i];
					int nc = p.c+dc[i];
					
					//배열 벗어났거나 방문한 곳이거나 빈 공간이면 컨티뉴
					if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc] || arr[nr][nc]==-1) continue;
					
					//토마토 익음
					arr[nr][nc] = 1;
					visited[nr][nc] = true;
					q.add(new Point(nr,nc,p.date+1));
				}
			}
			//다 익었는지 확인
			zero = false;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					//안익은 토마토 나오면 zero를 true로 바꿔주고 반복문 나가기
					if(arr[i][j] == 0) {
						zero = true;
						break;
					}
				}
			}
			if(zero) System.out.println(-1);//안 익은 토마토 있으면 -1출력
			else System.out.println(ans);//다 익었으면 최소 날짜 출력
		}
	}
}