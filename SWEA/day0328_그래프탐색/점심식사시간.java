package 그래프탐색;

import java.util.Scanner;

public class 점심식사시간 {
	
	static int N;
	static int[][] arr, d;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();//방 한변의 길이
			
			//지도 정보 입력받아서 배열에 저장
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			visited = new boolean[N][N];
			d = new int[N][N];//방문 순서 저장할 배열
			
			//2차원 배열 순회하면서 사람 나오면 bfs실시
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
				}
			}
			
			
		}//tc

	}

	

}
