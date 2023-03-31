package 문제풀이;
import java.util.Scanner;

public class 장훈이의높은선반_재귀 {
	
	static int N, B,ans;//N:점원의 수 1~20, B:선반의 높이
	static int[] H;//점원들의 키 저장할 배열
	static boolean[] sel;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			H = new int[N];
			for(int i=0; i<N; i++) {
				H[i] = sc.nextInt();
			}
			
			ans = Integer.MAX_VALUE;
			sel = new boolean[N];
			
			powerset(0);
						
			System.out.println("#"+tc+" "+(ans-B));

		}//tc
	}//main

	private static void powerset(int idx) {
		if(idx==N) {
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(sel[i]) sum += H[i];
			}
			if(sum >= B) ans = Math.min(ans, sum);
			return;
		}
		
		sel[idx] = true;
		powerset(idx+1);
		sel[idx] = false;
		powerset(idx+1);
		
	}
}//class
