import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//행 크기
		int M = Integer.parseInt(st.nextToken());//열 크기
		
		//맵 정보 입력받아서 배열에 저장
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		
		int[][][] visited = new int[2][N][M];//방문 순서(거리) 배열  (0: 벽 안 부쉈을 때, 1: 벽 부쉈을 때)
		
		//bfs
		//1. 큐에 시작 위치 넣기
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(0,0,false));
		visited[0][0][0] = 1;//이동거리 저장
		visited[1][0][0] = 1;
		
		//상하좌우 델타값
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		//2. 큐가 빌 때까지 현재 위치에서 이동할 수 있는 곳 큐에 집어 넣기
		while(!q.isEmpty()) {
			Point curr = q.poll();
			int r = curr.r;
			int c = curr.c;
			
			for(int i=0; i<4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
					
				//배열 범위 벗어났으면 컨티뉴
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				//벽 부순적 없을 때 방문하려는 곳이 벽 안부수고 방문했던 곳이면 컨티뉴
				if(!curr.smash && visited[0][nr][nc]>0) continue;
				//벽 부순적 있을 때 방문하려는 곳이 벽 부수고 방문했던 곳이면 컨티뉴
				if(curr.smash && visited[1][nr][nc]>0) continue;
					
				if(arr[nr][nc]==0) {//이동할 수 있는 곳이면 이동하기
					q.add(new Point(nr,nc,curr.smash));
					if(curr.smash) visited[1][nr][nc] = visited[1][r][c]+1;
					else visited[0][nr][nc] = visited[0][r][c]+1;
				}else if(!curr.smash) {//벽 만났는데 아직 벽 안 부순 경우 벽 부수고 이동하기
					q.add(new Point(nr,nc,true));
					visited[1][nr][nc] = visited[0][r][c]+1;
				}
			}	
		}
		if(visited[0][N-1][M-1]==0 && visited[1][N-1][M-1]==0) System.out.println(-1);//방문 못하면 -1출력
		else if(visited[1][N-1][M-1]==0)System.out.println(visited[0][N-1][M-1]);//벽 없는 경우 벽 안부수고 갔을 때의 최단 거리 출력
		else System.out.println(visited[1][N-1][M-1]);//벽 부수고 갔을 때의 최단거리 출력
	}
	
	static class Point{
		int r,c;
		boolean smash;//벽 부쉈는지 여부
		
		public Point(int r, int c, boolean smash) {
			this.r = r;
			this.c = c;
			this.smash = smash;
		}
	}

}