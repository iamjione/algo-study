import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			int N = sc.nextInt();//열의 크기
			
			//스티커 점수 입력받아서 배열에 저장
			int[][] arr = new int[2][N+2];
			for(int i=0; i<2; i++) {
				for(int j=2; j<N+2; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int[][] dp = new int[2][N+2];
			for(int i=2; i<N+2; i++) {
				dp[0][i] = Math.max(dp[1][i-1]+arr[0][i], Math.max(dp[0][i-2], dp[1][i-2])+arr[0][i]);
				dp[1][i] = Math.max(dp[0][i-1]+arr[1][i], Math.max(dp[0][i-2], dp[1][i-2])+arr[1][i]);
			}
			
			System.out.println((int)Math.max(dp[0][N+1], dp[1][N+1]));
		}//tc

	}

}