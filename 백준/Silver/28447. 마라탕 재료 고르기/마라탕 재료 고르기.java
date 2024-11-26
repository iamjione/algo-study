import java.util.*;

public class Main {
	
	static int N, K;
	static int[][] arr;
	static int max = Integer.MIN_VALUE;
	static int[] selected;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// 재료 하나만 고를 경우 마라탕 맛 0
		if(K==1) {
			System.out.println(0);
			return;
		}
		
		selected = new int[K];
		visited = new boolean[N];
		
		recur(0);
		
		System.out.println(max);
	}
	
	public static void recur(int idx) {
		if(idx == K) {
			int sum = 0;
			for(int i=0; i<K-1; i++) {
				for(int j=i+1; j<K; j++) {
					sum += arr[selected[i]][selected[j]];
				}
			}
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			
			selected[idx] = i;
			visited[i] = true;
			recur(idx+1);
			visited[i] = false;
		}
			
	}

}