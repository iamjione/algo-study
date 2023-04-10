package day0404문제풀이;

import java.util.Scanner;

public class 핀볼게임 {

	static int N, max, score;
	static int[][] arr;
	//상하좌우 델타값
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();//게임판 크기
			arr = new int[N+2][N+2];
			
			//벽 11로 저장
			for(int i=0; i<N+2; i++) {
				arr[0][i] = arr[N+1][i] = 11;
				arr[i][0] = arr[i][N+1] = 11;
			}
			
			//게임판 정보 입력받아서 배열에 저장
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			max = 0;//점수의 최대값 초기화
			
			//2차원 배열을 순회하면서 게임 시작이 가능한 모든 칸에서 게임 시작해보기
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					if(arr[i][j]==0) {//빈칸이면 게임 시작 가능
						for(int k=0; k<4; k++) {//시작 방향
							score = 0;
							int row = i;
							int col = j;
							int d = k;
							while(true) {
								int nr = row+dr[d];
								int nc = col+dc[d];
								int idx = 1;
								while(arr[nr][nc]==0) {
									nr = row+dr[d]*idx;
									nc = col+dc[d]*idx;
									idx++;
								}
								
								//블랙홀 만났거나 출발점으로 돌아왔으면 점수의 최대값 갱신해주고 게임 종료
								if(arr[nr][nc]==-1 || (nr==i&&nc==j)) {
									if(max<score) max = score;
									break;
									
								//5번 블록이나 벽 만났으면 최종 점수 계산 후 최대값 갱신해주고 게임 종료
								}else if(arr[nr][nc]==5 || arr[nr][nc]==11) {
									score = score*2+1;
									if(max<score) max = score;
									break;
									
								//1번~4번 블록 만난 경우
								}else if(1<=arr[nr][nc] && arr[nr][nc]<=4) {
									switch(d) {
									case 0://위로 이동 중
										if(arr[nr][nc]==1 || arr[nr][nc] == 4) {
											//1번, 4번 블록 만났으면 게임 종료
											score = score*2+1;
											if(max<score) max = score;
											break;
										}else {
											//1점 획득 && 이동 방향 바꾸기
											score++;
											row = nr;
											col = nc;
											if(arr[nr][nc]==2) d=3; 
											else if(arr[nr][nc]==3) d=2;
										}
										break;
									case 1://아래로 이동 중
										if(arr[nr][nc]==2 || arr[nr][nc] == 3) {
											//2번, 3번 블록 만났으면 게임 종료
											score = score*2+1;
											if(max<score) max = score;
											break;
										}else {
											//1점 획득 && 이동 방향 바꾸기
											score++;
											row = nr;
											col = nc;
											if(arr[nr][nc]==1) d=3;
											else if(arr[nr][nc]==4) d=2;
										}
										break;
									case 2://왼쪽으로 이동 중
										if(arr[nr][nc]==3 || arr[nr][nc]==4) {
											//3번,4번 블록 만났으면 게임 종료
											score = score*2+1;
											if(max<score) max = score;
											break;
										}else {
											//1점 획득 && 이동 방향 바꾸기
											score++;
											row = nr;
											col = nc;
											if(arr[nr][nc]==1) d=0;
											else if(arr[nr][nc]==2) d=1;
										}
										break;
									default://오른쪽으로 이동 중
										if(arr[nr][nc]==1 || arr[nr][nc]==2) {
											//1번 블록 만났으면 게임 종료
											score = score*2+1;
											if(max<score) max = score;
											break;
										}else {
											//1점 획득 && 이동 방향 바꾸기
											score++;
											row = nr;
											col = nc;
											if(arr[nr][nc]==3) d=1;
											else if(arr[nr][nc]==4) d=0;
										}
										break;
									}
								}else{
									//웜홀이면 반대쪽 웜홀로 나오기
									for(int r=1; r<N+1; r++) {
										for(int c=1; c<N+1; c++) {
											if(r!=nr || c!=nc && arr[nr][nc]==arr[r][c]) {
												//nr,nc 에서 r,c로 이동
												row = r;
												col = c;
											}
										}
									}
								}
							}
						}
					}
				}
			}
			System.out.println("#"+tc+" "+max);
		}//tc

	}


//	private static void gameStop(int score) {
//		//블록이나 벽을 만나서 이동 방향이 완전 반대로 바뀌면 왔던 길 되돌아가기때문에
//		//지금까지 점수에 2배 +1 점이 최종 점수!
//		score = score*2+1;
//		if(max<score) max = score;
//	}
	
	

}
