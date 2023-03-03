package IM대비;

import java.util.Scanner;

public class 백만장자프로젝트 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();//숫자 개수
			
			int[] arr = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
				
			}
			
			long profit = 0;//이익
			int maxIdx = 0;//최대값의 인덱스
			int idx = 0;//시작 위치
			
			while(idx<N) {
				//범위 내 최대값 찾기
				for(int i=idx; i<N; i++) {
					if(arr[i]>arr[maxIdx]) maxIdx = i;
				}
				//최대값 전까지 이익 ++
				for(int i=idx; i<maxIdx; i++) {
					profit += arr[maxIdx]-arr[i];
				}
				//최대값 다음 인덱스 부터 다시 탐색
				idx = maxIdx+1;
				maxIdx++;
			}
			
			System.out.println("#"+tc+" "+profit);
		}
	}
}