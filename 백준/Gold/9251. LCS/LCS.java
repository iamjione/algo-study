import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//문자열 입력받아서 char 배열로 저장
		char[] c1 = sc.next().toCharArray();
		char[] c2 = sc.next().toCharArray();

		int N = c1.length;//첫번째 문자열의 길이
		int M = c2.length;//두번째 문자열의 길이
		
		int[][] dp = new int[N+1][M+1];//문자열의 길이+1 크기로 2차원 배열 만들어줌
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				//문자가 같으면 배열의 왼쪽 대각선 위의 수에 1 더한 값 저장
				if(c1[i]==c2[j]) dp[i+1][j+1] = dp[i][j]+1;
				//문자가 다르면 배열의 왼쪽과 위쪽 중에 더 큰 수 저장
				else dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
			}
		}
		System.out.println(dp[N][M]);
	}

}