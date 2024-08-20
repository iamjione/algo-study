import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//숫자 개수
		int M = Integer.parseInt(st.nextToken());//구간합 구해야 하는 횟수
		
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
		}//누적합 배열
		
		StringBuilder sb = new StringBuilder();
		for(int k=0; k<M; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			//i번째수부터 j번째 수까지의 합 = 누적합 배열arr[j]-arr[i-1]
			sb.append(arr[j]-arr[i-1]).append('\n');
		}
		
		System.out.println(sb);
		
	}

}