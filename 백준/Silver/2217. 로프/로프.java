import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//로프 개수
		
		//각 로프가 버틸 수 있는 최대 중량 입력받기
		int[] arr = new  int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);//오름차순 정렬
		
		int ans = arr[N-1];//로프로 들 수 있는 물체의 최대 중량
		int k = 1;//사용한 로프 개수
		
		//최대하중 큰 것 부터 차례대로 더해주면서
		//ans보다 더 많은 중량 들 수 있는 경우 나오면 ans에 저장
		for(int i=N-2; i>=0; i--) {
			k++;
			if(arr[i]*k >= ans) {
				ans = arr[i]*k;
			}
		}	
		System.out.println(ans);
	}
}