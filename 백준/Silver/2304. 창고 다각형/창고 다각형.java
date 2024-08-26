import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[1002];
		
		for(int i=0; i<N; i++) {
			arr[sc.nextInt()] = sc.nextInt();
		}
		
		int[] prefix_max = new int[1002];
		for(int i=1; i<=1000; i++) {
			prefix_max[i] = Math.max(arr[i], prefix_max[i-1]);
		}
		
		int[] sufix_max = new int[1002];
		for(int i=1000; i>=1; i--) {
			sufix_max[i] = Math.max(arr[i], sufix_max[i+1]);
		}
		
		// prefix_max와 sufix_max 중 최소값들의 합 구하기
		int ans = 0;
		for(int i=1; i<=1000; i++) {
			ans += Math.min(prefix_max[i], sufix_max[i]);
		}
		
		System.out.println(ans);
	}
}