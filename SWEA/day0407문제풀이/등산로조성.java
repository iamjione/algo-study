package day0407문제풀이;

import java.util.Scanner;

public class 등산로조성 {

	static int N, K, ans;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();//지도 크기
			K = sc.nextInt();//최대 공사 가능 깊이
			
			int max = 0;//가장 높은 봉우리의 높이
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
					//1. 조건문
					if(arr[i][j]>max) max = arr[i][j];
					//2. max메서드
//					max = Math.max(max, arr[i][j]);
					//3. 삼항 연산자
//					max = max<arr[i][j]?arr[i][j]:max;
				}
			}
			
			ans = 0;//답으로 출력할 값
			visited = new boolean[N][N];//방문표시할 배열
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j]==max) DFS(i,j,1,false);
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}//tc

	}//main

	//i:행, j:열 len:등산로 길이 construct:공사 여부
	private static void DFS(int i, int j, int len, boolean construct) {
		//등산로 최장 길이 갱신
		if(len>ans) ans = len;
		
		visited[i][j] = true;//방문체크
		
		for(int d=0; d<4; d++) {
			int nr = i+dr[d];
			int nc = j+dc[d];
			
			//배열 벗어났거나 방문했으면 컨티뉴
			if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) continue;
			
			//(nr,nc)가 현재 위치보다 낮으면 DFS진행
			if(arr[nr][nc]<arr[i][j]) DFS(nr,nc, len+1, construct);
			//(nr,nc)가 현재 위치보다 높지만 공사 가능 한 경우 공사하고 DFS진행
			else if(!construct && arr[i][j]>arr[nr][nc]-K) {
				int tmp = arr[nr][nc];//원래 높이 임시 저장
				arr[nr][nc] = arr[i][j]-1;//공사하기
				DFS(nr,nc, len+1, true);
				arr[nr][nc] = tmp;//높이 원상 복구
			}
		}
		visited[i][j] = false;//방문 체크 원상 복구
	}

}
