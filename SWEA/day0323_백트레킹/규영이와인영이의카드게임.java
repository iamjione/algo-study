package 백트레킹;

import java.util.Scanner;

public class 규영이와인영이의카드게임 {

	static int[] arr = new int[9];
	static boolean[] select;
	static int win, lose;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			select = new boolean[19];
			
			//규영이가 받은 카드번호 1로 표시
			for(int i=0; i<9; i++) {
				arr[i] = sc.nextInt();
				select[arr[i]] = true;
			}
			
			win = 0;//규영이가 이긴 횟수
			lose = 0;//규영이가 진 횟수
			
			game(0,0,0);
			
			System.out.println("#"+tc+" "+win+" "+lose);
		}

	}

	//idx:게임횟수 0~8까지 9번 
	//A: 규영이 점수 합
	//B: 인영이 점수 합
	private static void game(int idx, int A, int B) {
		if(idx==9) {//게임끝났을 때
			if(A>B) win++; //규영이 점수가 더 높으면 이긴 횟수 증가
			else if(A<B) lose++;//인영이 점수가 더 높으면 진 횟수 증가
			return;
		}
		
		for(int i=1; i<19; i++) {
			//규영이 카드거나 인영이가 이미 쓴 카드면 못 쓰니까 컨티뉴
			if(select[i]) continue;
			
			//사용한 카드 체크해줌
			select[i] = true;
			//규영이가 낸 카드 숫자가 더 작을 때
			if(arr[idx]<i) game(idx+1, A, B+i-arr[idx]);
			//규영이가 낸 카드 숫자가 더 클 때
			else game(idx+1, A+arr[idx]-i, B);
			select[i] = false;//카드 사용 표시 원상복구	
		}
		
		
	}

}
