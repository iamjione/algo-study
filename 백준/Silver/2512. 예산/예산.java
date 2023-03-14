import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N,M;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//지방의 수
		
		//배열에 각 지방별 예산 요청 입력받기 && 합 구하기
		arr = new int[N];
		long sum = 0;
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		Arrays.sort(arr);
		
		M = sc.nextInt();//총 예산
		
		if(M>=sum) {//모든 요청 들어줄  수 있는 경우 예산 요청 중 제일 큰 금액 출력
			System.out.println(arr[N-1]);
		}else {//모든 요청 들어줄 수 없는 경우 이분탐색으로 상한값 정하기
			System.out.println(binarySearch());
		}
	}

	//이분탐색
	private static long binarySearch() {
		long start = 0;
		long end = arr[N-1];

		while(start<=end) {
			long mid = (start+end)/2;
			
			//상한액 mid일때 총 예산 지급액 구하기
			long sum = 0;
			for(int i=0; i<N; i++) {
				if(arr[i]>mid) sum += mid;//상한액 초과하는 경우 상한액만큼만 배정
				else sum += arr[i];//아니면 요청 금액 배정
			}
			
			if(sum>M) {//예산 초과하는 경우 상한액 더 낮춰야함
				end = mid-1;
			}else if(sum<M) {//예산 남는 경우 상한액 늘려도 됨
				start = mid+1;
			}else {//예산에 딱 맞는 경우
				return mid;
			}
		}
		return end;	
	}

}