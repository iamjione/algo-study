import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] arr1 = sc.next().toCharArray();
		char[] arr2 = sc.next().toCharArray();

		int n = arr1.length+1;
		int m = arr2.length+1;
		int[][] dp = new int[n][m];
		
		for(int i=1; i<n; i++) {
			for(int j=1; j<m; j++) {
				if(arr1[i-1]==arr2[j-1]) dp[i][j] = dp[i-1][j-1]+1;
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		System.out.println(dp[n-1][m-1]);
		
		if(dp[n-1][m-1]!=0) {
			StringBuilder sb = new StringBuilder();
			int i=n-2;//arr1의 인덱스 
			int j=m-2;//arr2의 인덱스
			while(i>=0 && j>=0) {
				if(dp[i+1][j+1] == dp[i][j+1]) i--;
				else if(dp[i+1][j+1] == dp[i+1][j]) j--;
				else {
					sb.append(arr1[i]);
					i--;
					j--;
				}
			}
			System.out.println(sb.reverse());
		}
		
	}

}