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
		
		recur(0);
		
		System.out.println(sb.toString());
	}

	private static void recur(int idx) {
		if(idx == M) {
			for(int n : answer) {
				sb.append(n+" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=1; i<=N; i++) {
			answer[idx] = i;
			recur(idx+1);
		}
	}

}