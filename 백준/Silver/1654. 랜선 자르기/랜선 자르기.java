import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//입력받기
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();//주어진 랜선 개수
		int N = sc.nextInt();//목표 랜선 개수
		//랜선 길이 배열에 저장
		int[] arr = new int[K];
		for(int i=0;i<K;i++) arr[i] = sc.nextInt();
		
		//랜선길이 오름차순 정렬
		Arrays.sort(arr);
		
		long min = 1;
		long max = arr[K-1];
		
		while(min<=max) {
			long mid = (min+max)/2;
			
			int ans = 0;
			for(int x:arr) {
				ans += x/mid;
			}
			if(ans<N) {
				max=mid-1;
			}else if(ans>=N){
				min = mid+1;
			}
		}
		System.out.println(max);
	
	
	}

}
