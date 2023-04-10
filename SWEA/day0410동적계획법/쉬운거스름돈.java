package day0410동적계획법;

import java.util.Scanner;

public class 쉬운거스름돈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();//거슬러 줘야할 금액

			int[] money = {50000,10000,5000,1000,500,100,50,10};
			int[] ans = new int[8];//각 종류의 돈 몇개 필요한지 저장할 배열
			for(int i=0; i<8; i++) {
				if(money[i]>N) continue;
				
				ans[i] = N/money[i];
				N %= money[i];
			}
			System.out.println("#"+tc);
			for(int i=0; i<8; i++) {
				System.out.print(ans[i]+" ");				
			}
			System.out.println();
		}//tc
	}

}
