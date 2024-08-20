import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] prefix_sum = new int[N+1];
		for(int i=1; i<=N; i++) {
			prefix_sum[i] = sc.nextInt() + prefix_sum[i-1];
		}
		
		int max = Integer.MIN_VALUE;
		for(int i= K; i<=N; i++) {
			max = Math.max(max, prefix_sum[i] - prefix_sum[i-K]);
		}
		
		System.out.println(max);
	}

}