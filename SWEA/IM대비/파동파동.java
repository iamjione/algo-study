package IM대비;

import java.util.Scanner;

public class 파동파동 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();//배열 크기
			int[][] arr = new int[N+1][N+1];//배열 인덱스 1부터 시작하니까 크기 N+1로 설정
			int M = sc.nextInt();//파동 시작 값
			int R = sc.nextInt();//행
			int C = sc.nextInt();//열
			int D = sc.nextInt();//증감
			
			arr[R][C] = M;// 파동 시작 위치 값 변경
			
			int range = Math.max(N-R, R);//반복문 반복 횟수 정하기
			
			for(int i=1; i<=range; i++) {
				for(int r=R-i; r<=R+i; r++) {//행 범위: R-i ~ R+i
					for(int c=C-i; c<=C+i; c++) {//열 범위: C-i ~ C+i
						//(r,c)가 배열을 벗어나지 않고 arr[r][c]의 값이 아직 없고
						//(r,c)가 파동 시작 위치가 아닌 경우 값 변경해줌
						if(0<r && r<=N && 0<c && c<=N && arr[r][c]==0 && !(r==R && c==C)) {
							if(M+D*i>255) arr[r][c] = 255;
							else if(M+D*i<0) arr[r][c] = 0;
							else arr[r][c] = M+D*i;
						}
						
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);
			for(int i=1; i<=N; i++) {
				int sum = 0;
				for(int j=1; j<=N; j++) {
					sum += arr[i][j];
				}
				sb.append(" ").append(sum);
			}
			
			System.out.println(sb);
			
		}
	}

}
