package IM대비;

import java.util.Scanner;

public class 시간개념 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//테스트 케이스 수
		for(int tc=1; tc<=T; tc++) {
			String[] pTime = sc.next().split(":");//현재 시각
			String[] fTime = sc.next().split(":");//약속 시각
			
			int pH = Integer.parseInt(pTime[0]);//현재 시간
			int pM = Integer.parseInt(pTime[1]);//현재 분
			int pS = Integer.parseInt(pTime[2]);//현재 초
			
			int fH = Integer.parseInt(fTime[0]);//약속 시간
			if(fH==0) fH = 24;
			int fM = Integer.parseInt(fTime[1]);//약속 분
			int fS = Integer.parseInt(fTime[2]);//약속 초
			
			//약속 시간까지 남은 초
			if(fS-pS<0) {
				fM--;
				fS += 60;
			}
			int S = fS-pS;
			//약속 시간까지 남은 분
			if(fM-pM<0) {
				fH--;
				fM += 60;
			}
			int M = fM - pM;
			//약속시간까지 남은 시
			int H = fH-pH;
			//약속시각이 현재시각보다 빠른 경우 
			if(H<0) {
				H = 24-pH+fH;	
			}

			System.out.printf("#%d %02d:%02d:%02d\n",tc,H,M,S);
	
		}
	}
}