package IM대비;

import java.util.Scanner;

public class 숫자배열회전 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//테스트 케이스 수
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();//배열 크기
			
			//NxN배열에 숫자 입력받기
			int[][] arr = new int [N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<N; i++) {
				//90도
				for(int j=N-1; j>=0; j--) {
					sb.append(arr[j][i]);
				}
				sb.append(" ");
				//180도
				for(int j=N-1; j>=0; j--) {
					sb.append(arr[N-i-1][j]);
				}
				sb.append(" ");
				//270도
				for(int j=0; j<N; j++) {
					sb.append(arr[j][N-i-1]);
				}
				if(i==N-1) break;
				sb.append('\n');
			}
			System.out.println("#"+tc);
			System.out.println(sb);
		}

	}

}
