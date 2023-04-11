import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			int N = sc.nextInt();//동전 종류
			//동전 금액 입력받기
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int M = sc.nextInt();//만들어야할 금액
			
			int[] dp = new int[M+1];
			dp[0] = 1;
			for(int i=0; i<N; i++) {
				for(int j=arr[i]; j<M+1; j++) {
					dp[j] +=dp[j-arr[i]];
				}
			}
			
			System.out.println(dp[M]);
		}
	}
}