import java.util.Scanner;

public class Main {

	static int N,M;
	static int[] arr;
	static int sum = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//N일 동안
		M = sc.nextInt();//M번 돈 인출
		
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}

		System.out.println(binarySearch());
		
	}

	private static int binarySearch() {
		int start = 0;
		int end = sum;
		
		while(start<=end) {
			int mid = (start+end)/2;
			
			int cnt = 1;//돈 인출하는 횟수
			int K = mid;//한번에 인출하는 금액
			for(int i=0; i<N; i++) {
				if(arr[i]>mid) {//돈 새로 인출해도 부족한 경우 인출 금액 늘려야함
					cnt = M+1;//카운트 M보다 큰 값으로 초기화해주고
					break;//break해서 start = mid+1로 인출 금액 늘리기
				}
					
				if(K-arr[i]<0) {//돈 부족할 경우 다시 인출하고 인출횟수 카운트
					K = mid;
					cnt++;
				}
				K -= arr[i];//돈 쓰기
			}
			
			if(cnt<=M) {//M번보다 더 적게 인출했다면 한번에 인출하는 금액 낮춰도 됨
				end = mid-1;
			}else {//M번보다 더 많이 인출했다면 한번에 인출하는 금액 올려야됨
				start = mid+1;
			}	
		}
		return start;
		
	}

}