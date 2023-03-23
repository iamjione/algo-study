package 백트래킹;

import java.util.Scanner;

public class 최소생산비용 {

	static int[][] arr;
	static boolean[] select;
	static int N,min;//최소 비용
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();//제품 수
			
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			select = new boolean[N];
			min = Integer.MAX_VALUE;
			findMin(0,0);
			
			System.out.println("#"+tc+" "+min);
			
		}//tc
	}

	private static void findMin(int r, int cost) {
		if(r==N) {
			if(cost<min) min = cost;
			return;
		}
		
		
		for(int c=0; c<N; c++) {//r:행(제품) c:열(공장)
			//이미 선택한 공장이면 컨티뉴
			if(select[c]==true) continue;
			//이미 비용이 min을 넘었으면 컨티뉴
			if(cost>=min) continue;
			
			//선택하지 않은 곳이면 선택하고 다음 행에 대해 findMin 진행
			select[c] = true;
			findMin(r+1, cost+arr[r][c]);
			select[c] = false;//선택 원상 복구
		}
		
	}

}
