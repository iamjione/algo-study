package day0410������ȹ��;

import java.util.Scanner;

public class ����Ž����� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();//�Ž��� ����� �ݾ�

			int[] money = {50000,10000,5000,1000,500,100,50,10};
			int[] ans = new int[8];//�� ������ �� � �ʿ����� ������ �迭
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
