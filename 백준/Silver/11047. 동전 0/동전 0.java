import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//동전 종류 수
		int K = sc.nextInt();//목표 금액
		
		int[] arr = new int[N];//동전 배열
		
		for(int i=N-1; i>=0; i--) {
			arr[i] = sc.nextInt();
		}
		
		int cnt = 0;//K원 만드는데 필요한 동전 개수
		for(int i=0; i<N; i++) {
			if(arr[i]>K) continue;//K원보다 동전 금액이 크면 컨티뉴
			
			cnt += K/arr[i];//동전 개수 카운트
			K = K%arr[i];//남은 금액 갱신
			if(K==0) break;//0원 됐으면 반복문 벗어나기
		}
		System.out.println(cnt);

	}

}