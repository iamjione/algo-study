import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int T = sc.nextInt();
		
		int[] airCleaner = new int[2];//공기 청정기 위치
		int idx = 0;//ariCleaner배열의 인덱스
		int[][] arr = new int[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				arr[i][j] = sc.nextInt();
				
				if(idx==2) continue;//공기 청정기 위치 찾았으면 컨티뉴
				if(arr[i][j]==-1) {
					airCleaner[idx++]=i;
				}
			}
		}
		
		//상하좌우 델타값
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		for(int tc=0; tc<T; tc++) {
			//1. 미세먼지 확산
			int[][] plus = new int[R][C];//각 칸에 더해질 미세먼지 양
			int[][] minus = new int[R][C];//각 칸에서 확산될 미세먼지 양
			
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(arr[i][j]>0) {
						int dust = arr[i][j]/5;//확산되는 양
						int cnt = 0;//확산되는 칸의 개수
						
						for(int d=0; d<4; d++) {
							int nr = i+dr[d];
							int nc = j+dc[d];
							//배열 벗어났거나 공기청정기 있는 곳이면 컨티뉴
							if(nr<0 || nr>=R || nc<0 || nc>=C || arr[nr][nc]==-1) continue;
							
							plus[nr][nc] += dust;
							cnt++;
						}
						minus[i][j] = dust*cnt;
					}
				}
			}
			//미세먼지 확산 된 후 각 칸의 미세먼지양 구하기
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					arr[i][j] = arr[i][j]+plus[i][j]-minus[i][j];
				}
			}

			
			//2. 공기청정기 작동
			int upRow = airCleaner[0];
			int downRow = airCleaner[1];
			
			int[][] tmp = new int[R][C];
			for(int i=0; i<R; i++) {
				tmp[i] = arr[i].clone();
			}
			
			arr[upRow][1] = 0;
			arr[downRow][1] = 0;
			for(int i=2; i<C; i++) {
				arr[upRow][i] = tmp[upRow][i-1];
				arr[downRow][i] = tmp[downRow][i-1];
			}
			
			for(int i=upRow-1; i>=0; i--) {
				arr[i][C-1] = tmp[i+1][C-1];
			}
			for(int i=downRow+1; i<R; i++) {
				arr[i][C-1] = tmp[i-1][C-1];
			}
			
			for(int i=C-2; i>=0; i--) {
				arr[0][i] = tmp[0][i+1];
				arr[R-1][i] = tmp[R-1][i+1];
			}
			
			for(int i=1; i<upRow; i++) {
				arr[i][0] = tmp[i-1][0];
			}
			
			for(int i=R-2; i>downRow; i--) {
				arr[i][0] = tmp[i+1][0];
			}
		}		
		
		int sum = 2;//공기청정기 -1 미리 빼주기
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sum += arr[i][j];
			}
		}
		System.out.println(sum);
	}

}