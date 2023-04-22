import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());//수열의 크기
		
		//수열 입력받아서 배열에 저장
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp1 = new int[N];//dp1[i] :0~i번째 원소 중 가장 긴 증가하는 부분수열의 길이
		int[] dp2 = new int[N];//dp2[i] :N-1~i번째 원소 중 가장 긴 증가하는 부분수열의 길이
		
		//0부터 N-1까지 가장 긴 증가하는 부분 수열 구하기
		dp1[0] = 1;
		int max = 1;
		for(int i=1; i<N; i++) {
			for(int j=i-1; j>=0; j--) {//i-1번째 원소부터 한칸씩 앞으로 가면서 비교
				//i번째 원소보다 작은 수 만나면 최장 길이 갱신
				if(A[i]>A[j]) dp1[i] = Math.max(dp1[i], dp1[j]+1);
			}
			//i번째 원소보다 작은 값이 없었다면 증가하는 부분 수열의 길이 == 1
			if(dp1[i]==0) dp1[i]=1;
		}
		
		//N-1부터 0까지 가장 긴 증가하는 부분 수열의 길이 구하기
		dp2[N-1]=1;
		max = 1;
		for(int i=N-2; i>=0; i--) {
			for(int j=i+1; j<N; j++) {
				if(A[i]>A[j]) dp2[i] = Math.max(dp2[i], dp2[j]+1);
			}
			if(dp2[i]==0) dp2[i]=1;
		}
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			if(dp1[i]+dp2[i]-1>ans) ans = dp1[i]+dp2[i]-1;
		}
		System.out.println(ans);
	}

}