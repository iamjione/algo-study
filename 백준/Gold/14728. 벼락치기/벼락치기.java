import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//시험의 단원 개수
		int T = sc.nextInt();//시험까지 공부할 수 있는 총 시간
		
		int[][] arr = new int[N+1][2];
		for(int i=1; i<N+1; i++) {
			arr[i][0] = sc.nextInt();//i단원의 예상 공부 시간
			arr[i][1] = sc.nextInt();//i단원 문제의 배점
		}

		int[][] dp = new int[N+1][T+1];
		for(int i=1; i<N+1; i++) {
			for(int j=0; j<T+1; j++) {
				//dp[i-1][j] - i단원 공부하지 않고 j시간 공부했을 때 받을 수 있는 최대 점수
				//dp[i-1][j-arr[i][0]]+arr[i][1] - i단원 공부하면서 j시간 공부했을 때 받을 수 있는 최대 점수
				if(arr[i][0]<=j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i][0]]+arr[i][1]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N][T]);
	}

}