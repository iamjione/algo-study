import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] arr, result;
	static boolean[] visited; 
	static StringBuilder sb;
	static LinkedHashSet<String> set;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		visited = new boolean[N];
		result = new int[M];
		set = new LinkedHashSet<>();//중복 제거를 위한 LinkedHashSet
		
		perm(0);

		sb = new StringBuilder();
		for(String s : set) sb.append(s).append('\n');
		System.out.println(sb);
	}

	private static void perm(int idx) {
		//M개 다 골랐으면 스트링 빌더에 답 저장하고 set에 넣고 재귀 종료
		if(idx==M) {
			sb = new StringBuilder();
			for(int x:result) sb.append(x+" ");
			set.add(sb.toString());
			return;
		}
				
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;

			result[idx] = arr[i];
			visited[i] = true;
			perm(idx+1);
			visited[i] = false;
		}
	}

}