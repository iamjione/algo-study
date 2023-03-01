package IM대비;

import java.util.Scanner;

public class 삼성시의버스노선 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();//버스 개수
			//배열에 버스 정보 입력받기
			int[][] bus = new int[N][2];
			for(int i=0; i<N; i++) {
				//A이상 B이하의 정류장 다님
				bus[i][0] = sc.nextInt();//A
				bus[i][1] = sc.nextInt();//B
			}
			
			int P = sc.nextInt();//버스 정류장 개수
			//배열에 버스 정류장 번호 입력 받기
			int[] busStop = new int[P];
			for(int i=0; i<P; i++) {
				busStop[i]=sc.nextInt();
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);
			for(int i=0; i<P; i++) {
				int cnt = 0;//지나가는 버스 수
				for(int j=0; j<N; j++) {
					//i번째 정류장이 j번째 버스가 지나가는 정류장 번호에 포함되면 카운트
					if(bus[j][0]<=busStop[i] && busStop[i]<=bus[j][1]) cnt++;
				}
				sb.append(" ").append(cnt);
			}
			
			System.out.println(sb);

		}

	}

}
