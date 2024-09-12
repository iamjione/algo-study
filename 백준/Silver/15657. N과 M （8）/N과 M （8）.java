import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] arr;
	static int[] ans;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		ans = new int[M];
		
		recur(0,0);
		
		System.out.println(sb.toString());
	}

	private static void recur(int curr, int idx) {
		if(idx==M) {
			for(int n : ans) {
				sb.append(n+" ");
			}
			sb.append('\n');
			return;
		}
		
		if(curr>=N) return;
		
		// curr번째 고르기
		ans[idx] = arr[curr];
		recur(curr, idx+1);
		
		// curr번째 안고르기
		recur(curr+1, idx);
	}

}