import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//물건의 수
		int K = sc.nextInt();//버틸 수 있는 무게

		int[] weight = new int[N+1];
		int[] value = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N+1][K+1];
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=K; j++) {
				if(weight[i] <= j) {
					//현재 고려하고 있는 물건 배낭에 넣을지 말지 판단
					//현재 j의 최적해는 dp[i-1][j]
					//i번째 물건을 넣었을 떼 최적해는 dp[i-1][j-weight[i]]+value[i];
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
				}else {
					dp[i][j]=dp[i-1][j];// 무게 j에 i번째 물건 담을 수 없어서 이전에 넣은 값이 최선
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}