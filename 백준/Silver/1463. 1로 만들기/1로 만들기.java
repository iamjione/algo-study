import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N+1];
//		arr[1] = 0; 이거 굳이 안써도 초기값 0
		
		for(int i=2; i<N+1; i++) {
			arr[i] = arr[i-1]+1;
			
			if(i%2==0 && i%3==0) {//2의 배수이고 3의 배수인 경우 1먼저 빼는거,2나누는거,3나누는거 비교해서 최소값 배열에 저장
				if(arr[i] > arr[i/2]+1) arr[i] = arr[i/2]+1;
				if(arr[i] > arr[i/3]+1) arr[i] = arr[i/3]+1;
			}else if(i%2==0) {//2의 배수인 경우 1먼저 빼는 거랑 2먼저 나누는거 비교해서 최소값 배열에 저장
				if(arr[i] > arr[i/2]+1) arr[i] = arr[i/2]+1;
			}else if(i%3==0) {//3의 배수인 경우 1먼저 빼는거랑 3먼저 나누는거 비교해서 최소값 배열에 저장
				if(arr[i] > arr[i/3]+1) arr[i] = arr[i/3]+1;
			}
		}
		System.out.println(arr[N]);
	}
}