import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//수열 A의 크기
		
		//수열 A의 원소 입력받기
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		
		//가장 긴 증가하는 부분 수열의 길이 찾기위해 사용할 리스트
		ArrayList<Integer> list = new ArrayList<>();
		//가장 긴 증가하는 부분 수열을 구성하는 원소를 찾기 위해 사용할 배열
		int[] P = new int[N];
		
		list.add(A[0]);//처음에 리스트 비어있으니까 첫번째 원소 리스트에 추가
		P[0] = 0;//배열에 리스트에서의 인덱스 저장 
		for(int i=1; i<N; i++) {
			//A[i]가 리스트의 마지막 원소보다 크면 리스트에 추가 && 배열에 리스트 인덱스 저장
			if(A[i]>list.get(list.size()-1)) {
				list.add(A[i]);
				P[i] = list.size()-1;
			//A[i]가 리스트의 마지막 원소보다 작거나 같으면 A[i]가 들어갈 위치 찾기 위해 이분탐색 실시
			}else {
				int start = 0;
				int end = list.size()-1;
				//A[i]보다 크거나 같은 값이 처음으로 나오는 위치 찾기
				while(start<end) {
					int mid = (start+end)/2;
					if(list.get(mid)>=A[i]) end = mid;
					else start = mid+1;
				}
				list.set(end, A[i]);
				P[i] = end;//배열에 리스트에서의 인덱스 저장 
			}
		}

		//부분 수열 원소 ans 배열에 저장
		int[] ans = new int[list.size()];
		int idx = list.size()-1;
		for(int i=N-1; i>=0; i--) {
			if(P[i]==idx) {
				ans[idx] = A[i];
				idx--;
				if(idx==-1) break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append('\n');//가장 긴 증가하는 부분 수열의 길이
		for(int n:ans) sb.append(n+" ");//부분 수열의 원소
		System.out.println(sb);

	}

}