import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// 누적합 배열 만들기
		int[][] prefix_sum = new int[N+1][N+1];
		// 행 누적합
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				prefix_sum[i][j] = sc.nextInt() + prefix_sum[i][j-1];
			}
		}
		// 열 누적합
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				prefix_sum[i][j] += prefix_sum[i-1][j];
			}
		}
		
		// 구간합 출력
		StringBuilder sb = new StringBuilder();
		int x1, y1, x2, y2;
		for(int i=0; i<M; i++) {
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			sb.append(prefix_sum[x2][y2] - prefix_sum[x2][y1-1] - prefix_sum[x1-1][y2] + prefix_sum[x1-1][y1-1]).append('\n');
		}
		
		System.out.println(sb.toString());
	}

}