import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//수열 A의 크기
		
		//수열의 값 입력받아서 배열에 저장
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		//DP - 가장 긴 증가하는 부분수열의 길이 찾기
		int[] dp = new int[N];
		dp[0] = 1;
		for(int i=1; i<N; i++) {
			//dp[i] : i번째 원소까지 봤을 때 가장 긴 증가하는 부분수열의 길이
			for(int j=i; j>=0; j--) {
				if(A[i]>A[j]) {//i번째 원소보다 작은 수 만나면 최장 길이 갱신
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			//i번째 원소보다 작은 값이 없었다면 길이 == 1
			if(dp[i]==0) dp[i]=1;
		}
		
		int max = 0;//답으로 출력할 부분 수열의 최장 길이
		for(int i=0; i<N; i++) {
			if(max<dp[i]) max=dp[i];
		}
		System.out.println(max);
	}

}