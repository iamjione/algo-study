package day0404����Ǯ��;

import java.util.Scanner;

public class �������� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();//���� ��� Ƚ��
			int W = sc.nextInt();//��
			int H = sc.nextInt();//��
			
			int[][] arr = new int[H][W];
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
		}

	}

}
