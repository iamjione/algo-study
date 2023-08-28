import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=1; i<=N; i++) arr[i] = sc.nextInt();

		dp[1] = arr[1];
		if(N>=2) dp[2] = arr[1]+arr[2];
		if(N>=3) dp[3] = Math.max(arr[1], arr[2]) + arr[3];

	    for (int i=4; i<=N; i++) {
	    	dp[i] = Math.max(dp[i-3] + arr[i-1], dp[i-2]) + arr[i];
	    }

		System.out.println(dp[N]);
	}

}