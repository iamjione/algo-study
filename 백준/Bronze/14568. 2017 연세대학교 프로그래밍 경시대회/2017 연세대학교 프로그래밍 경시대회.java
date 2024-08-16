import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt = 0;// 경우의 수
		
		for(int i=2; i<N; i+=2) {// 택희
			for(int j=1; j<N; j++) { // 영훈
				for(int k=j+2; k<N; k++) { // 남규
					if(i+j+k == N) cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}

}