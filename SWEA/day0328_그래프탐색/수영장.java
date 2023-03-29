package 그래프탐색;

import java.util.Scanner;

public class 수영장 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int[] cost = new int [4];//1일, 1달, 3달, 1년
			for(int i=0; i<4; i++) {
				cost[i] = sc.nextInt();
			}
			
			//이용 계획 * 1일 비용 이랑 1달 비용 중 더 작은 값 배열에 저장
			int[] min = new int[13];
			for(int i=1; i<=12; i++) {
				min[i] = Math.min(sc.nextInt()*cost[0], cost[1]);
			}


			//3달 요금제
			int[] dp = new int[13];
			dp[1] = Math.min(min[1], cost[2]);
			dp[2] = Math.min(dp[1]+min[2], cost[2]);
			dp[3] = Math.min(dp[2]+min[3], cost[2]);
			
			for(int i=4; i<=12; i++) {
				//i월이 3개월 요금제의 시작 월/중간 월/끝 월인 경우의 누적 요금 중 최소값
				int threeMonth = Math.min(dp[i-3]+cost[2], Math.min(dp[i-2]+cost[2], dp[i-1]+cost[2]));
				//dp[i]: i월에 3개월 요금제 안쓰는 경우와 3개월 요금 쓰는 경우 중 최소값
				dp[i] = Math.min(dp[i-1]+min[i], threeMonth);
			}

			//1년 요금제
			int ans = Math.min(dp[12], cost[3]);
			
			System.out.println("#"+tc+" "+ans);
			
		}//tc

	}

}
