import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());//테스트 케이스
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());//정수 N
			
			if(N==1) System.out.println(1);
			else if(N==2) System.out.println(2);
			else if(N>=3) {
				int[] dp = new int[N+1];//1,2,3으로 N만들 수 있는 경우의 수 구할 dp배열
				dp[1] = 1;
				dp[2] = 2;
				dp[3] = 4;
				for(int i=4; i<=N; i++) {
					dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
				}
				System.out.println(dp[N]);
			}	
		}	
	}
}