import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N,M;
	static int[] arr, result;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		result = new int[M];
		visited = new boolean[N];
		sb = new StringBuilder();
		
		perm(0);
		System.out.println(sb);
	}

	private static void perm(int idx) {
		if(idx == M) {
			for(int x:result) sb.append(x+" ");
			sb.append('\n');
			return;
		}
		
		//모든 요소를 반복문을 통해 돌면서 사용하지 않은 요소가 있다면 
		//result에 넣고 사용했다고 표시 & 다음 차례로 내려가 봄
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			
			result[idx] = arr[i];
			visited[i] = true;
			perm(idx+1);
			visited[i] = false;//원상복구
		}
		
	}

}