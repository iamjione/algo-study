import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//수열의 길이
		int K = Integer.parseInt(st.nextToken());//같은 원소의 개수
		
		//원소 입력받아서 배열에 저장
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] cnt = new int[100001];
		int len = 1;//최장 연속 부분 수열의 길이
		int i = 0;//수열 시작 인덱스
		int j=1;//수열 끝 인덱스
		cnt[arr[i]]++;
		while(j<N) {
			if(cnt[arr[j]]<K) {//수열에 arr[j] 포함 할 수 있는 경우
				cnt[arr[j]]++;
				j++;
			}else {//수열에 더이상 arr[j] 포함할 수 없는 경우	
				if(j-i>len) len=j-i;//최장 길이 갱신
				cnt[arr[i++]]--;
			}
		}
		if(j-i>len) len=j-i;//최장 길이 갱신
		System.out.println(len);
	}
}