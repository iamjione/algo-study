package day0410동적계획법;

import java.util.Scanner;

public class 햄버거다이어트 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();//재료 개수
			int L = sc.nextInt();//제한 칼로리
			
			//재료별 점수와 칼로리 입력받아서 배열에 저장
			int[] score = new int[N+1];
			int[] cal = new int[N+1];
			for(int i=1; i<=N; i++) {
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			
			int[][] dp = new int[N+1][L+1];
			for(int i=1; i<=N; i++) {//재료 하나씩 늘려가면서 고려
				for(int j=0; j<=L; j++) {//j: 제한 칼로리
					if(cal[i] <= j) {//제한칼로리보다 i번째 재료의 칼로리가 작은 경우 i번째 재료 추가할 수 있음
						//i번째 재료 넣지 않은 경우와 넣은 경우 중 점수가 더 큰 값을 dp[i][j]에 저장
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cal[i]]+score[i]);
					}else {//칼로리 제한때문에 i번째 재료를 넣을 수 없는 경우 이전의 점수가 최선의 경우
						dp[i][j]=dp[i-1][j];
					}
				}
			}
			System.out.println("#"+tc+" "+dp[N][L]);
		}//tc

	}

}
