import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] ans;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		ans = new int[M];
		
		recur(1,0);
		
		System.out.println(sb.toString());
	}

	private static void recur(int curr, int idx) {
		if(idx == M) {
			for(int n : ans) {
				sb.append(n+" ");
			}
			sb.append('\n');
			return;
		}
		
		if(curr > N) return;
		
		// curr 선택하기
		ans[idx] = curr;
		recur(curr, idx+1);
		
		// curr 선택 안하기
		recur(curr+1, idx);
	}

}