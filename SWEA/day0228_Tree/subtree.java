package day0228_Tree;

import java.util.Scanner;

public class subtree {
	static int E;
	static int N;
	static int[][] arr;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			E = sc.nextInt();//간선 개수
			N = sc.nextInt();//subtree의 루트
			arr = new int[E+2][2];//노드 번호 1부터 E+1
			cnt = 0;//답으로 출력할 카운트 초기화
			
			//부모-자식-부모-자식 순서로 입력받으면서
			//부모의 인덱스에 자식 입력받기
			for(int i=1; i<=E; i++) {
				int parent = sc.nextInt();
				int child = sc.nextInt();
				if(arr[parent][0]==0) {
					//아직 자식 노드가 없으면
					arr[parent][0]=child;
				}else {
					//자식 하나 있으면 두번째 자식
					arr[parent][1] = child;
				}
			}
			subtreeCnt(N);
			System.out.println("#"+tc+" "+cnt);
			
		}

	}
	
	public static void subtreeCnt(int N) {
		cnt++;
		if(arr[N][0]!=0) {
			subtreeCnt(arr[N][0]);
		}
		if(arr[N][1]!=0) {
			subtreeCnt(arr[N][1]);
		}
	}

}
