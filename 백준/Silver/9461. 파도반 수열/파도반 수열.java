import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			if(N<=3) {//N이 3 이하일 때 1 출력
				System.out.println(1);
			}
			else {//N이 3보다 클 때 dp 실행
				long[] dp = new long[N+1];
				dp[1] = 1;
				dp[2] = 1;
				dp[3] = 1;
				for(int i=4; i<=N; i++) {
					dp[i] = dp[i-3]+dp[i-2];
				}
				System.out.println(dp[N]);
			}
		}
	}
}