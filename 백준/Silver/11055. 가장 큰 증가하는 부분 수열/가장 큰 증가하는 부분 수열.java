import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//수열 크기
		
		//배열에 수열 입력받기
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}

		//증가하는 부분 수열의 합 기록할 배열
		int[] sum = new int[N];
		sum[0] = arr[0];
		
		for(int i=1; i<N; i++) {
			for(int j=i-1; j>=0; j--) {
				//나보다 작은 값이 있고 걔랑 더하는게 합이 더 커지면 거기까지의 합에 나 자신 더해줌
				if(arr[i]>arr[j] && sum[i]<sum[j]+arr[i]) {
					sum[i] = sum[j]+arr[i];
				}
			}
			//내 앞에 나보다 작은 애 없으면 나부터 나부터 새로운 합 시작
			if(sum[i]==0) sum[i]=arr[i];
		}
		
		//증가하는 부분 수열의 합 중 최대값 찾기
		int max = 0;
		for(int i=0; i<N; i++) {
			if(sum[i]>max) max = sum[i];
		}
		
		System.out.println(max);
	}

}