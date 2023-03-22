import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] A;
	static int N, K;
	static int cnt = 0;//교환 횟수 카운트
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());//배열의 크기
		K = Integer.parseInt(st.nextToken());//교환 횟수
		
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(0,N-1);
		if(cnt<K) System.out.println(-1);//교환횟수가 K보다 적으면 -1 출력
	}

	//퀵정렬
	private static void quickSort(int L, int R) {
			
		if(L>=R) return;
			
		int pivot = partition(L, R);
		quickSort(L, pivot-1);
		quickSort(pivot+1, R);
			
	}

	//Lomuto partition
	private static int partition(int L, int R) {
		int pivot = A[R];
		int i= L-1;
			
		for(int j=L; j<R; j++) {
			if(A[j]<=pivot) {
				i++;
				swap(i,j);
			}
		}
		if(i+1 != R) swap(i+1, R);
		return i+1;
	}

	//A[i]랑 A[j] 교환
	private static void swap(int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
		cnt++;
        //K번째 카운트면 그 때 배열 A의 원소 출력
		if(cnt==K) {
			StringBuilder sb = new StringBuilder();
			for(int n: A) sb.append(n).append(" ");
			System.out.println(sb);
		}
	}
	
}