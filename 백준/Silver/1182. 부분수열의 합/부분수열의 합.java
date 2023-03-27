import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int S;
	static int cnt;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}//입력완료
		
		//부분수열 구하기
		cnt = 0;
		subset(0);
		if(S==0) cnt-=1;
		sb.append(cnt);
		
		System.out.println(sb);
		
	}//main

	private static void subset(int idx) {
		if(idx==N) {
			int sum = 0;
			for(int i= 0; i<N; i++) {
				if(visited[i])
					sum += arr[i];
			}
			if (sum == S) cnt++;
			return;
		}
		
		visited[idx] = true;
		subset(idx+1);
		visited[idx] = false;
		subset(idx+1);
		
	}//subset

}//class