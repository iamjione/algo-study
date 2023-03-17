import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//강의 수
		int M = Integer.parseInt(st.nextToken());//블루레이 수
		
		//배열에 강의 시간 입력받아서 저장
		int max = 0;
		int sum = 0;//이분 탐색 범위 지정을 위해 강의 시간 중 최대값&강의 시간 합 구하기
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			sum += arr[i];
			if(arr[i]>max) max = arr[i];
		}
		
		int start = max;
		int end = sum;
		while(start<=end) {
			int mid = (start+end)/2;
			
			int size = 0;//블루레이 크기
			int cnt = 1;//블루레이 개수
			//mid만큼의 사이즈로 블루레이 만들면 블루레이 총 몇개 필요한지 카운트
			for(int i=0; i<N; i++) {
				if(size+arr[i]<=mid) {
					size += arr[i];
				}else {
					cnt++;
					size = arr[i];
				}
			}
			
			if(cnt>M) {//M보다 블루레이 개수 더 많이 사용한 경우 블루레이 사이즈 늘려야 됨
				start = mid+1;
			}else {//M보다 적거나 같은 개수 사용한 경우 블루레이 사이즈 줄여도 됨
				end = mid-1;				
			}
			
		}
		System.out.println(start);
	}
}