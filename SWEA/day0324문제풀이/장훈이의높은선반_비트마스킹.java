package 문제풀이;
import java.util.Scanner;

public class 장훈이의높은선반_비트마스킹 {
	
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
			
			//비트마스킹 사용
			for(int i=0; i<(1<<N); i++) {//모든 부분집합 순회
				int sum = 0;
				for(int j=0; j<N; j++) {
					if((i&(1<<j)) != 0) sum += H[j];
				}//탑쌓기 끝
				if(sum>=B && sum<ans) {
					ans = sum;
				}
			}
						
			System.out.println("#"+tc+" "+(ans-B));

		}//tc
	}//main
}//class
