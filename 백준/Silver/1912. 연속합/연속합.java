import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());//숫자 개수
		
		//배열에 숫자 입력받기
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sum = new int[N];//최대 연속 합 구할 배열
		sum[0] = arr[0];//첫번째 수 sum 배열에 넣기
		
		for(int i=1; i<N; i++) {
			//arr[i] 이전까지의 연속 합을 arr[i]와 더했을 때 arr[i]보다 크면 더해주고
			//아니면 그냥 arr[i]가 새로운 연속 합이 됨
			if(arr[i]+sum[i-1]>arr[i]) sum[i] = arr[i]+sum[i-1];
			else sum[i] = arr[i];
		}
		
		Arrays.sort(sum);
		System.out.println(sum[N-1]);
	}

}