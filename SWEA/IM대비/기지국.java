package IM대비;

import java.util.Scanner;

public class 기지국 {
	static int n;
	static char[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			n = sc.nextInt();//배열 크기
			
			//배열에 지도 정보 입력받기
			arr = new char[n][n];
			for(int i=0; i<n; i++) {
				arr[i] = sc.next().toCharArray();
			}
			
			//H: 집, A,B,C: 기지국
			//2차원 배열 순회하면서 기지국 나오면 범위 내에 있는 집 커버
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][j]=='A') cover(i,j,1);
					else if(arr[i][j]=='B') cover(i,j,2);
					else if(arr[i][j]=='C') cover(i,j,3);
				}
			}
			
			//H개수 카운트
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][j]=='H') cnt++;
				}
			}
			System.out.println("#"+tc+" "+cnt);
			
		}
	}
	
	//(r,c)에 위치한 기지국이 k만큼의 범위 커버하는 함수
	//기지국으로 커버되는 집 H>>X로 바꿈
	private static void cover(int r, int c, int k) {
		//사방탐색을 위한 상하좌우 델타값
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		for(int i=1; i<=k; i++) {
			for(int j = 0; j<4; j++) {
				int nr = r+dr[j]*i;
				int nc = c+dc[j]*i;
				//배열 안에 있고 집인 경우에 X로 바꿔줌
				if(0<=nr && nr<n && 0<=nc && nc<n && arr[nr][nc]=='H')
					arr[nr][nc]='X';
			}
		}	
	}

}
