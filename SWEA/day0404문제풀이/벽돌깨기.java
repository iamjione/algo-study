package day0404문제풀이;

import java.util.Scanner;

public class 벽돌깨기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();//구슬 쏘는 횟수
			int W = sc.nextInt();//열
			int H = sc.nextInt();//행
			
			int[][] arr = new int[H][W];
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
		}

	}

}
