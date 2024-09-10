import java.util.Scanner;

public class Main {
	
	static int N, M;
	static boolean[] visited;
	static int[] ans;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new boolean[N+1];
		ans = new int[M];
		
		recur(0);
		
		System.out.println(sb.toString());
	}

	private static void recur(int idx) {
		if(idx == M) {
			for(int n : ans) {
				sb.append(n+" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(visited[i]) continue;
			
			ans[idx] = i;
			visited[i] = true;
			recur(idx+1);
			visited[i] = false;
		}
	}

}