import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int max = -1000;
	static int[] arr;
	static int[] sel;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		sel = new int[N];
		visited = new boolean[N];
		
		select(0);
		
		System.out.println(max);
	}

	private static void select(int idx) {
		if(idx==N) {
			int sum = 0;
			
			for(int i=1; i<N; i++) {
				sum += Math.abs(sel[i]-sel[i-1]);
			}
			
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			
			sel[idx] = arr[i];
			visited[i] = true;
			select(idx+1);
			visited[i] = false;
		}
	}
}