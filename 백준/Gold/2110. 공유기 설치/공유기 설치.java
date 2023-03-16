import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//집 개수
		int C = Integer.parseInt(st.nextToken());//공유기 개수

		//배열에 집 위치 입력받아서 저장하기
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//정렬
		Arrays.sort(arr);
		
		//이분탐색
		int start = 0;
		int end = arr[N-1];
		while(start<=end) {
			int mid = (start+end)/2;//거리
			
			//최소 거리를 mid로 했을 때 공유기 몇 개 설치할 수 있는지 카운트
			int cnt = 1;
			int idx = 0;
			for(int i=1; i<N; i++) {
				if(arr[i]>=arr[idx]+mid) {
					cnt++;
					idx = i;
				}
			}
			
			if(cnt>=C) {//공유기가 C개 보다 많거나 같게 설치된 경우 거리 늘려야됨
				start = mid+1;				
			}else {//공유기가 C개보다 적게 설치된 경우 거리 줄여야 함
				end = mid-1;
			}
		}
		System.out.println(end);
	}

}