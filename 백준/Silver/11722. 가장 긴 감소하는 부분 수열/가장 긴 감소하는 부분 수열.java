import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//수열 A의 크기
		
		//수열 A의 원소 입력받기
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i]=sc.nextInt();
		}
		
		//가장 긴 감소하는 부분 수열의 길이 찾기위해 사용할 리스트
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(A[0]);//처음에 리스트 비어있으니까 첫번째 원소 리스트에 추가
		for(int i=1; i<N; i++) {
			//A[i]가 리스트의 마지막 원소보다 작으면 리스트에 추가
			if(A[i]<list.get(list.size()-1)) {
				list.add(A[i]);
			//A[i]가 리스트의 마지막 원소보다 크거나 같으면 A[i]가 들어갈 위치 찾기 위해 이분탐색 실시
			}else {
				int start = 0;
				int end = list.size()-1;
				//A[i]보다 작거나 같은 값이 처음으로 나오는 위치 찾기
				while(start<end) {
					int mid = (start+end)/2;
					if(list.get(mid)<=A[i]) end = mid;
					else start = mid+1;
				}
				list.set(end, A[i]);
			}
		}
		
		//리스트의 사이즈 == 가장 긴 감소하는 부분 수열의 길이
		//!!! 리스트에 들어있는 원소들이 가장 긴 부분 수열의 원소들은 아님 !!!
		System.out.println(list.size());
	}

}