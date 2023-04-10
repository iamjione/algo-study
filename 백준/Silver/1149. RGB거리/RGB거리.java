import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//집의 수
		
		//각 집을 빨강,초록,파랑으로 칠하는 비용 입력받아서 배열에 저장
		int[][] cost = new int[N+1][3];
		for(int i=1; i<N+1; i++) {
			cost[i][0] = sc.nextInt();
			cost[i][1] = sc.nextInt();
			cost[i][2] = sc.nextInt();
		}
		
		int[][] dp = new int[N+1][3];
		for(int i=1; i<N+1; i++) {
			//i번째 집을 빨간색으로 칠할 때의 최소 비용 == i-1번째집을 초록색으로 칠했을 때랑 파란색으로 칠했을 때 중 비용이 더 최소인 경우 + 빨간색으로 칠하는 비용
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+cost[i][0];
			//i번째 집을 초록색으로 칠할 때의 최소 비용 == i-1번째집을 빨간색으로 칠했을 때랑 파란색으로 칠했을 때 중 비용이 더 최소인 경우 + 초록색으로 칠하는 비용
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+cost[i][1];
			//i번째 집을 파란색으로 칠할 때의 최소 비용 == i-1번째집을 빨간색으로 칠했을 때랑 초록색으로 칠했을 때 중 비용이 더 최소인 경우 + 파란색으로 칠하는 비용
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+cost[i][2];
		}
		
		int ans = Integer.MAX_VALUE;//답으로 출력할 최소 비용
		for(int i=0; i<3; i++) {
			if(dp[N][i]<ans) ans = dp[N][i];
		}
		
		System.out.println(ans);
	}

}