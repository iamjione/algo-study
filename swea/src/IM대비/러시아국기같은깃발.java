package IM대비;

import java.util.Scanner;

public class 러시아국기같은깃발 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 줄
			int M = sc.nextInt();// 문자

			char[][] arr = new char[N][M];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.next().toCharArray();
			}

			// 흰색 칠 할 수 있는 범위: 첫번째~N-2번째 줄
			// 파란색 칠 할 수 있는 범위: 흰색 다음줄부터 N-1번째 줄
			// 빨간색 칠 할 수 있는 범위: 나머지줄

			int minCnt = M * N;// 새로 칠해야하는 칸의 개수의 최소값
			
			for (int i = 1; i <= N - 2; i++) {// 흰색줄 범위
				for (int j = i + 1; j <= N - 1; j++) {// 파란색줄 범위
					int cnt = 0;
					for (int r = 0; r < i; r++) {
						for (int c = 0; c < M; c++) {
							if (arr[r][c] != 'W') cnt++;
						}
					}
					
					for (int r = i; r < j; r++) {
						for (int c = 0; c < M; c++) {
							if (arr[r][c] != 'B') cnt++;
						}
					}
					for (int r = j; r < N; r++) {// 빨
						for (int c = 0; c < M; c++) {
							if (arr[r][c] != 'R') cnt++;
						}
					}
					if (cnt < minCnt) minCnt = cnt;
				}
			}
			System.out.println("#" + tc + " " + minCnt);
		} 
	}
}