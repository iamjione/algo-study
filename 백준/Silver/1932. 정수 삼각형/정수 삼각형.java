import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//삼각형의 크기
		
		//수 입력받아서 배열에 저장하기
		int[][] arr = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<i+1; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		//dp
		int[][] dp = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
                //왼쪽 위에 있는 수와 더하는 경우랑 바로 위에 있는 수와 더하는 경우 중 최대값 dp에 저장
				dp[i][j] = Math.max(dp[i-1][j-1]+arr[i][j],dp[i-1][j]+arr[i][j]);
			}
		}
		
		//n번째 줄에서 최대값 찾기
		int max = 0;
		for(int i=1; i<N+1; i++) {
			if(dp[N][i]>max) max = dp[N][i];
		}
		System.out.println(max);
	}

}