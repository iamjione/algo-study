import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//블로그 시작하고 지난 일 수
		int X = Integer.parseInt(st.nextToken());//방문자 수 알고싶은 기간
		
		//배열에 누적합 저장
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		for(int i=1; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken())+arr[i-1];
		}
		
		int max = 0;//가장 많이 들어온 방문자 수
		int cnt = 0;//최대 방문자 수인 기간 몇개인지

		int i=0;
		
		while(i<=N-X) {			
			int j=i+X-1;
			
			if(i==0) {
				if(max<arr[j]) {
					max=arr[j];
					cnt = 1;
				}
			}else {
				if(max<arr[j]-arr[i-1]) {
					max = arr[j]-arr[i-1];
					cnt = 1;
				}else if(max==arr[j]-arr[i-1]) {
					max = arr[j]-arr[i-1];
					cnt += 1;
				}
			}
			i++;
		}
		if(max==0) System.out.println("SAD");
		else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}

}