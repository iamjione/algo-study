package Day0404문제풀이;

import java.util.Scanner;

public class 새로운마음으로시작하는핀볼게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();//게임판 크기
			
			int[][] arr = new int[N+2][N+2];//게임판 배열
			
			//게임판 정보 입력받아서 배열에 저장
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			//벽인 부분 5로 저장
			for(int i=0; i<N+2; i++) {
				arr[0][i] = arr[N+1][i] = 5;
				arr[i][0] = arr[i][N+1] = 5;
			}
			
			//상하좌우 델타값
			int[] dr = {-1,1,0,0};
			int[] dc = {0,0,-1,1};
			
			int ans = 0;//답으로 출력할 최대 점수
			
			//2차원 배열 순회
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					if(arr[i][j]==0) {//빈공간이라면 게임 시작
						for(int k=0; k<4; k++) {//시작 방향 상하좌우
							int score = 0;
							int nr = i;
							int nc = j;
							int dir = k;
							boolean end = false;//게임 종료 여부
							
							while(true) {
								//블랙홀/블록/웜홀/벽 만날 때까지 이동
								while(arr[nr][nc]==0) {
									nr += dr[dir];
									nc += dc[dir];
									//이동하다가 시작점으로 돌아오면 끝내기
									if(nr==i && nc==j) {
										end = true;
										break;
									}
								}
								
								if(end) break;
								
								//(nr,nc)가 블랙홀인 경우
								if(arr[nr][nc]==-1) {
									break;
								}
								//(nr,nc)가 5인 경우
								else if(arr[nr][nc]==5) {
									score = score*2+1;
									break;
								}
								//(nr,nc)가 1~4번 블록인 경우
								else if(1<=arr[nr][nc] && arr[nr][nc]<=4) {
									int block = arr[nr][nc];//블록 번호
									
									if(dir==0) {//위로 이동 중
										if(block==1 || block==4) {
											score = score*2+1;
											break;
										}else if(block==2) {
											score++;
											dir=3;
											nc += dc[dir];
										}else {
											score++;
											dir=2;
											nc += dc[dir];
										}
									}else if(dir==1) {//아래로 이동 중
										if(block==2 || block==3) {
											score = score*2+1;
											break;
										}else if(block==1) {
											score++;
											dir=3;
											nc += dc[dir];
										}else {
											score++;
											dir=2;
											nc += dc[dir];
										}
									}else if(dir==2) {//왼쪽으로 이동 중
										if(block==3 || block==4) {
											score = score*2+1;
											break;
										}else if(block==1) {
											score++;
											dir=0;
											nr += dr[dir];
										}else {
											score++;
											dir=1;
											nr += dr[dir];
										}
									}else {//오른쪽으로 이동 중
										if(block==1 || block==2) {
											score = score*2+1;
											break;
										}else if(block==3) {
											score++;
											dir=1;
											nr += dr[dir];
										}else {
											score++;
											dir=0;
											nr += dr[dir];
										}
									}
								}
								//(nr,nc)가 웜홀인 경우
								else {
									int num = arr[nr][nc];//웜홀 번호
									for(int r=1; r<N+1; r++) {
										for(int c=1; c<N+1; c++) {
											if(arr[r][c]==num && (r!=nr || c!=nc)) {
												//반대편 웜홀로 이동
												nr = r+dr[dir];
												nc = c+dc[dir];
											}
										}
									}
								}
							}
							
							//최고점 갱신
							if(score>ans) ans = score;
							
						}
					}
				}
			}
			
			System.out.println("#"+tc+" "+ans);
			
		}//tc
	}
}