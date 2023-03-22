import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] A, tmp;
	static int N,K;
	static int cnt = 0;//저장횟수 카운트
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());//배열의 크기
		K = Integer.parseInt(st.nextToken());//저장 횟수
		
		A = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		tmp = new int[N];
		mergeSort(0,N-1);
		
		if(cnt==K) {
			StringBuilder sb = new StringBuilder();
			for(int n : A) sb.append(n).append(" ");
			System.out.println(sb);
		}
		else System.out.println(-1);
	}

	private static void mergeSort(int L, int R) {
		
		if(L>=R) return;
		
		int mid = (L+R)/2;
		mergeSort(L,mid);//왼쪽 분할
		mergeSort(mid+1, R);//오른쪽 분할
		if(cnt==K) return;
		merge(L,mid,R);//정렬하면서 병합
		
	}

	private static void merge(int L, int mid, int R) {
		int left = L;//왼쪽 구역 시작 인덱스
		int right = mid+1;//오른쪽 구역 시작 인덱스
		
		int idx = left;
		
		while(left<=mid && right<=R) {//한쪽 값 다 쓸 때까지 반복
			//left랑 right값 중에 더 작은 값 tmp[idx]에 저장
			if(A[left]<=A[right]) tmp[idx++]=A[left++];
			else tmp[idx++]=A[right++];	
		}
		
		//남아있는 애들도 배열에 넣어줌
		if(left<=mid) {//왼쪽 구역에 숫자 남아있는 경우
			for(int i=left; i<=mid; i++) tmp[idx++] = A[i];
		}else {//오른쪽 구역에 숫자 남아있는 경우
			for(int i=right; i<=R; i++) tmp[idx++] = A[i];
		}
		
		//정렬 끝난 tmp배열 원본배열A로 옮겨줌
		for(int i=L; i<=R; i++) {
			A[i] = tmp[i];
			cnt++;
			if(cnt==K) return;//저장횟수가 K면 return
		}
		
	}

}