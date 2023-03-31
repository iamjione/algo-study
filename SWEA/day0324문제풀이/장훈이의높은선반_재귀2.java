package 문제풀이;
import java.util.Scanner;

public class 장훈이의높은선반_재귀2 {
	
	static int N, B,ans;//N:점원의 수 1~20, B:선반의 높이
	static int[] H;//점원들의 키 저장할 배열
	
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
			
			powerset(0,0);
						
			System.out.println("#"+tc+" "+(ans-B));

		}//tc
	}//main

	private static void powerset(int idx, int sum) {
		if(idx==N) {
			if(sum>=B) ans = Math.min(ans, sum);
			return;
		}
		
		powerset(idx+1, sum+H[idx]);//idx번째 사람 쌓고 다음으로
		powerset(idx+1, sum);//idx번째 사람 안 쌓고 다음으로
		
	}
}//class
