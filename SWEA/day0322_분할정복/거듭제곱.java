package 분할정복;

import java.util.Scanner;

public class 거듭제곱 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=0; tc<10; tc++) {
			int T = sc.nextInt();//테스트 케이스 번호
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println("#"+T+" "+pow(N,M));
		}
	}

	//N의 M거듭제곱 구하는 함수
	private static int pow(int N, int M) {
		
		if(M==1) return N;
				
		//1. 짝수일 때
		if(M%2==0) {
			int Y = pow(N,M/2);
			return Y*Y;
		//2. 홀수일 때
		}else {
			int Y = pow(N,(M-1)/2);
			return Y*Y*N;
		}
	}

}
