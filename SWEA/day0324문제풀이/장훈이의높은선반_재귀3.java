package 문제풀이;
import java.util.Scanner;

public class 장훈이의높은선반_재귀3 {
	
	static int N, B,ans;//N:점원의 수 1~20, B:선반의 높이
	static int[] H;//점원들의 키 저장할 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			H = new int[N];
			int rs = 0; //모든 점원의 키의 합
			for(int i=0; i<N; i++) {
				H[i] = sc.nextInt();
				rs += H[i];
			}
			
			ans = Integer.MAX_VALUE;
			
			powerset(0,0,rs);
						
			System.out.println("#"+tc+" "+(ans-B));

		}//tc
	}//main

	private static void powerset(int idx, int sum, int rsum) {
		
		if(sum > ans) return; //중간 과정의 합이 ans보다 크면 더 볼 필요 없음
		
		if(idx==N) {
			if(sum>=B) ans = Math.min(ans, sum);
			return;
		}
		
		//sum 	: 지금까지의 합
		//rsum  : 앞으로 나한테 더해질 수 있는 합
		if(sum + rsum < B) return; //앞으로 더할 수 있는 숫자들 다 더해도 선반 높이보다 낮으면 return
		
		powerset(idx+1, sum+H[idx], rsum - H[idx]);//idx번째 사람 쌓고 다음으로
		powerset(idx+1, sum, rsum - H[idx]);//idx번째 사람 안 쌓고 다음으로
		
	}
}//class
