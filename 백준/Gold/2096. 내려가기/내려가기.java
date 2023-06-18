import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//배열의 줄 수
		
		//배열 정보 저장
		int[][] arr = new int[N][3];
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();
		}
		
		//최대값 찾기
		int[][] dp = new int[N][3];
		for(int i=0; i<N; i++) dp[i] = arr[i].clone();//깊은 복사
		
		for(int i=1; i<N; i++) {
			dp[i][0] += Math.max(dp[i-1][0], dp[i-1][1]);
			dp[i][1] += Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
			dp[i][2] += Math.max(dp[i-1][1], dp[i-1][2]);			
		}
		
		int max = 0;
		for(int i=0; i<3; i++) {
			if(max<dp[N-1][i]) max = dp[N-1][i];
		}
		
		//최소값 찾기
		for(int i=0; i<N; i++) dp[i] = arr[i].clone();//깊은 복사
		for(int i=1; i<N; i++) {
			dp[i][0] += Math.min(dp[i-1][0], dp[i-1][1]);
			dp[i][1] += Math.min(dp[i-1][0], Math.min(dp[i-1][1], dp[i-1][2]));
			dp[i][2] += Math.min(dp[i-1][1], dp[i-1][2]);			
		}
		
		int min = 9*N;
		for(int i=0; i<3; i++) {
			if(min>dp[N-1][i]) min = dp[N-1][i];
		}
		
		System.out.println(max+" "+min);
	}

}