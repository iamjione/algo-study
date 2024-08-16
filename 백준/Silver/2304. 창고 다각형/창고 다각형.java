import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[1002];
		
		for(int i=0; i<N; i++) {
			arr[sc.nextInt()] = sc.nextInt();
		}
		
		// 각 x값의 위치에서 1~x까지 중 최대 높이 구하기
		int[] dp1 = new int[1002];
		for(int i=1; i<=1000; i++) {
			dp1[i] = Math.max(arr[i], dp1[i-1]);
		}
		
		// 각 x값의 위치에서 x~끝까지 중 최대 높이 구하기
		int[] dp2 = new int[1002];
		for(int i=1000; i>=1; i--) {
			dp2[i] = Math.max(arr[i], dp2[i+1]);
		}
		
		// 최대 높이 중 최소값 더하기
		int ans = 0;
		for(int i=1; i<=1000; i++) {
			ans += Math.min(dp1[i], dp2[i]);
		}
		
		System.out.println(ans);
	}
}