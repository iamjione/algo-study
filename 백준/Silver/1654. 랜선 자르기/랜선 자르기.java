import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt(); // 가지고 있는 랜선 수 
		int N = sc.nextInt(); // 필요한 랜선 수
		
		int[] arr = new int[K];
		long start = 1;
		long end = 0;
		for(int i=0; i<K; i++) {
			arr[i] = sc.nextInt();
			end = Math.max(end, arr[i]);
		}
		
		long mid = 0, cnt = 0;
		while(start<=end) {
			mid = (start+end)/2; // 랜선 길이
			cnt = 0; // mid로 잘랐을 때 랜선 개수
			
			for(int n : arr) {
				cnt += n/mid;
			}
			
			if(cnt>=N) {
				 start = mid+1;
			}else {
				end = mid-1;
			}
		}
		
		System.out.println(end);
	}

}