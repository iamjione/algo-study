import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] answer;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		answer = new int[M];
		
		recur(1, 0);
		
		System.out.println(sb.toString());
	}

	private static void recur(int start, int idx) {
		if(idx == M) {
			for(int n : answer) {
				sb.append(n+" ");
			}
			sb.append('\n');
			
			return;
		}
		
		for(int i=start; i<=N; i++) {
			answer[idx] = i;
			recur(i, idx+1);
		}
	}

}