package Day0406문제풀이;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 탈주범검거 {

	static int N, M, R, C, L, cnt;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();//세로 크기
			M = sc.nextInt();//가로 크기
			
			R = sc.nextInt();//맨홀 세로 위치
			C = sc.nextInt();//맨홀 가로 위치
			L = sc.nextInt();//탈출 후 소요 시간
			
			//지하터널 정보 입력받기
			arr = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			cnt = 0;
			visited = new boolean[N][M];
			bfs();
			System.out.println("#"+tc+" "+cnt);
		}//tc

	}

	private static void bfs() {
		Queue<RC> q = new ArrayDeque<>();
		
		q.offer(new RC(R,C,1));//맨홀 위치 큐에 넣어줌
		visited[R][C] = true;//방문 표시
		
		
		while(!q.isEmpty()) {
			//큐에서 방문할 위치 poll
			RC rc = q.poll();
			int r = rc.r;
			int c = rc.c;
			
			//(r,c)까지 가는데 L보다 오래걸린다면 더이상 볼 필요 없으므로 리턴
			if(rc.time>L) return;
			
			cnt++;//방문할 때마다 탈주범이있을 수 있는 장소 수 카운트
			
			//(r,c)에서 갈 수 있는 곳 방문
			for(int i=0; i<4; i++) {
				int nr = r+dr[i];//이동 위치 행
				int nc = c+dc[i];//이동 위치 열
				
				
				//배열 범위 벗어났거나 방문한 곳 또는 빈 공간이면 컨티뉴
				if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc] || arr[nr][nc]==0) continue;
				
				int curr = arr[r][c];//(r,c)의 구조물 번호

				if(curr==2 &&(i==2||i==3)) continue;//2번 구조물에서 좌우로 이동 못하므로 컨티뉴
				else if(curr==3 && (i==0||i==1)) continue;//3번 구조물에서 상하로 이동 못하므로 컨티뉴		
				else if(curr==4 &&(i==1||i==2)) continue;//4번 구조물에서 하좌로 이동 못하니까 컨티뉴
				else if(curr==5 &&(i==0||i==2)) continue;//5번 구조물에서 상좌로 이동 못하니까 컨티뉴 
				else if(curr==6 &&(i==0||i==3)) continue;//6번 구조물에서 상우로 이동 못하니까 컨티뉴
				else if(curr==7 &&(i==1||i==3)) continue;//7번 구조물에서 하우로 이동 못하니까 컨티뉴
					
				int next = arr[nr][nc];//이동할 곳의 구조물 번호				

				//현재 이동 방향(i)로 움직여서 갈 수 없는 구조물이면 컨티뉴
				if(i==0 && (next==3||next==4||next==7)) continue;
				if(i==1 && (next==3||next==5||next==6)) continue;
				if(i==2 && (next==2||next==6||next==7)) continue;
				if(i==3 && (next==2||next==4||next==5)) continue;
				
				//갈 수 있는 곳이면 큐에 넣어주기 & 방문 체크
				q.offer(new RC(nr,nc,rc.time+1));
				visited[nr][nc]=true;
			}	
		}
	}

	static class RC {
		int r, c, time;

		public RC(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
}
