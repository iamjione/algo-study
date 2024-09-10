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
		
		recur(1, 0);
		
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
		
		// curr 고르기
		ans[idx] = curr;
		visited[curr] = true;
		recur(curr+1, idx+1);
		
		// curr 안고르기
		visited[curr] = false;
		recur(curr+1, idx);
	}

}