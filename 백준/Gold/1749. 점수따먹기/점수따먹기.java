import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// 누적합 구하기
		int[][] arr = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				arr[i][j] = sc.nextInt() + arr[i][j-1];
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				arr[i][j] += arr[i-1][j];
			}
		}
		
		//(i,j) ~ (r,c)의 부분합 구해서 최대값 찾기
		int max = Integer.MIN_VALUE;
		int sum; // 부분합
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				for(int r=i; r<=N; r++) {
					for(int c=j; c<=M; c++) {
						sum = arr[r][c] - arr[r][j-1] - arr[i-1][c] + arr[i-1][j-1];
						max = Math.max(max, sum);
					}
				}
			}
		}
		
		System.out.println(max);
	}

}