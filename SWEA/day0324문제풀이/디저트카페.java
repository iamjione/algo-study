package 문제풀이;

import java.util.Scanner;

public class 디저트카페 {

	static int N, max;
	static int[][] arr;
	static boolean[] visited = new boolean[101];//방문 체크할 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();//배열 크기
			//배열 입력받기 & 최대값 찾기
			arr = new int[N][N];
			max = 0;//최대값
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			findmax(0);

		}//tc

	}//main

	//디저트 가장 많이 먹었을 때의 디저트 수 찾기
	private static void findmax(int idx) {
		
		
	}

}//class
