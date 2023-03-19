import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//동전 종류
		int K = Integer.parseInt(st.nextToken());//만드려는 가치의 합
		
		//배열에 각 동전의 가치 입력받아서 저장
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);//오름차순 정렬
		
		int[] dp = new int[K+1];//idx원을 만들 수 있는 경우의 수 저장할 배열
		
		dp[0] = 1;
		for(int i=0; i<N; i++) {
			for(int j=arr[i]; j<K+1; j++) {
				dp[j] += dp[j-arr[i]];
			}
		}
		
		System.out.println(dp[K]);//K원을 만드는 경우의 수
		
	}

}