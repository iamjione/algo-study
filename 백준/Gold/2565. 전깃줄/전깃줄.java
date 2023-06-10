import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//전깃줄 개수

		//배열에 전깃줄 정보 저장
		Connect[] arr = new Connect[N];
		for(int i=0; i<N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[i] = new Connect(a,b);
		}
		Arrays.sort(arr);
		
		int max = 1;//교차없이 연결할 수 있는 전깃줄의 최대 개수
		int[] dp = new int [N];
		dp[0] = 1;
		for(int i=1; i<N; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[i].b>arr[j].b) dp[i] = Math.max(dp[i], dp[j]+1);
			}
			max = Math.max(max, dp[i]);
		}
		
		//전체 전깃줄 개수 - 교차 없이 연결할 수 있는 전깃줄의 최대 개수 == 없애야 하는 전깃줄의 최소 개수
		System.out.println(N-max);
	}
	
	private static class Connect implements Comparable<Connect>{
		int a,b;

		public Connect(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Connect o) {
			return this.a-o.a;
		}
		
	}

}