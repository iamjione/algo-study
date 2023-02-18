import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//테스트 케이스
		
		for(int t=0; t<T; t++) {
			int H = sc.nextInt();//층 수
			int W = sc.nextInt();//각 층의 방 수
			int N = sc.nextInt();//몇번째 도착한 사람인지
			
			int room = 0;
			int floor = 0;
			
			if(N%H ==0) {//N이 H의 배수인 경우
				room = N/H;
				floor = H;
			}
			else {//N이 H의 배수가 아닌 경우
				room = N/H+1;
				floor = N-N/H*H;
			}
			System.out.println(floor*100+room);
		}
	}
}