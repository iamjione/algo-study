package 문제풀이;

import java.util.Scanner;

public class 보호필름 {

	static int D, W, K, min;
	static int[][] arr, copy;
	static int[] A, B;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			D = sc.nextInt();//필름 두께(행)
			W = sc.nextInt();//가로 크기(열)
			K = sc.nextInt();//합격 기준
			
			//배열 A,B 초기화
			A = new int[W];
			B = new int[W];
			
			//셀 특성 입력받아서 배열에 저장 && 배열B 초기화
			//A==0, B==1
			arr = new int[D][W];
			copy = new int[D][W];
			for(int i=0; i<D; i++) {
				for(int j=0; j<W; j++) {
					arr[i][j] = sc.nextInt();
					copy[i][j] = arr[i][j];
					B[j] = 1;
				}
			}
			
			min = K;
			findMin(0,0);
			System.out.println("#"+tc+" "+min);

		}//tc

	}//main

	//백트래킹으로 탐색하면서 투입 횟수 최소값 찾기
	//idx:탐색 깊이, cnt:주입 횟수
	private static void findMin(int idx, int cnt) {
		
		if(cnt>min) return;//카운트가 최소값보다 크면 더 안봐도 됨
		
		//성능 검사해서 참이면 최소값 갱신하고 return
		if(test()){
			if(min>cnt) min=cnt;
			return;
		}
		
		if(idx==D) return;//끝까지 다 봤으면 return
		
		
		findMin(idx+1,cnt);//주입 안하는 경우
		
		//A주입 하는 경우
		injection(idx,0);
		findMin(idx+1,cnt+1);
		
		//B주입 하는 경우
		injection(idx,1);
		findMin(idx+1, cnt+1);
		
		//idx행 값 원상복구
		arr[idx]=copy[idx];	
		
	}

	//주입
	private static void injection(int idx,int n) {
		if(n==0) {//A주입
			arr[idx] = A;
		}else {//B주입
			arr[idx] = B;
		}
		
	}

	//성능검사
	private static boolean test() {
		for(int c=0; c<W; c++) {
			boolean pass = false;
			for(int r=K-1; r<D; r++) {
				int sum = 0;
				for(int i=0; i<K; i++) {
					sum += arr[r-i][c];
				}
				if(sum==0 || sum==K) {
					pass = true;
					break;
				}
			}
			if(!pass) return false;
		}return true;
	}

}//class
