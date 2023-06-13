import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//방의 크기 NxM
		int N = sc.nextInt();
		int M = sc.nextInt();
		//로봇 청소기의 위치(r,c)
		int r = sc.nextInt();
		int c = sc.nextInt();
		//로봇청소기의 방향(0:북, 1:동, 2:남, 3:서)
		int d = sc.nextInt();
		
		//방의 상태(0:청소되지 않은 빈 칸, 1:벽)
		int[][] arr = new int [N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		//북동남서에서 반시계방향으로 90도 회전했을 때의 방향
		int[] dir = {3,0,1,2};
		//4방 탐색 델타값
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		//북동남서 방향별 전진
		int[] go = {0,3,1,2};
		//북동남서 방향별 후진
		int[] back = {1,2,0,3};
		
		int cnt = 0;//청소한 칸의 개수
		
		while(true) {
			//현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
			if(arr[r][c]==0) {
				cnt++;
				arr[r][c]=-1;
			}
			
			boolean check = true;//4방 탐색 중 청소되지 않은 빈칸이 있다면 false
			//4방 탐색
			for(int i=0; i<4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				
				// 청소되지 않은 빈 칸이 있는 경우 반시계방향으로 90도 회전 후
				// 한 칸 전진하는 곳이 청소하지 않은 빈칸이면 전진
				if(arr[nr][nc]==0) {
					d = dir[d];
					if(arr[r+dr[go[d]]][c+dc[go[d]]]==0) {
						r = r+dr[go[d]];
						c = c+dc[go[d]];						
					}
					check = false;
					break;
				}
			}
			//청소되지 않은 빈 칸이 없는 경우
			if(check) {
				//한 칸 후진할 수 있다면 한 칸 후진
				//바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동 멈춤
				if(arr[r+dr[back[d]]][c+dc[back[d]]]==-1) {
					r = r+dr[back[d]];
					c = c+dc[back[d]];
				}else {
					break;
				}
			}
		}
		System.out.println(cnt);
	}

}