import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] arr;
	static int[] answer;
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
		
		answer = new int[M];
		
		recur(0,0);
		
		System.out.println(sb.toString());
	}

	private static void recur(int start, int idx) {
		if(idx==M) {
			for(int i=0; i<M; i++) {
				sb.append(answer[i]+" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=start; i<N; i++) {
			answer[idx] = arr[i];
			
			recur(i+1, idx+1);
		}
	}

}