import java.util.Scanner;

public class Main {

	static int N;
	static int[][] arr;
	static int max1 = 0;
	static int max2 = 0;
	static int[][] d = {{-1,-1},{-1,1},{1,-1},{1,1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// 체스판 전체에 대해 탐색하면 시간 초과
		// 체스판을 흑백으로 나눠서 따로 탐색해서 각각의 최대값 더해주기
		// 체스판의 색이 같은 부분끼리만 영향 받기 때문!
		recur(0,0,0,0);
		recur(0,1,0,1);
		
		System.out.println(max1+max2);
	}

	private static void recur(int r, int c, int cnt, int startIdx) {
		
		r += c/N;
		if(c>=N) {
			if(startIdx==0) {
				if(r%2==0) c = 0;
				else c = 1;
			}else {
				if(r%2==0) c = 1;
				else c = 0;
			}
		}
		
		if(r==N) {
			if(startIdx==0) max1 = Math.max(max1, cnt);
			else max2 = Math.max(max2, cnt);
			return;
		}
		
		// (r,c)가 빈 공간이고 다른 비숍한테 안잡히면 비숍 놓기
		if(arr[r][c]==1 && valid(r,c)) {
			arr[r][c] = 2;
			recur(r, c+2, cnt+1, startIdx);
			arr[r][c] = 1;
		}
		
		// r,c에 비숍 안 놓고 다음칸으로 이동
		recur(r, c+2, cnt, startIdx);
	}

	
	private static boolean valid(int r, int c) {
		int nr, nc;
		for(int i=0; i<4; i++) {
			for(int j=1; j<N; j++) {
				nr = r+d[i][0]*j;
				nc = c+d[i][1]*j;
				
				if(nr<0 || nr>=N || nc<0 || nc>=N) break; // 범위 벗어났으면 끝내기
				
				if(arr[nr][nc]==2) return false;// 비숍 만나면 false 반환
			}
		}
		return true;
	}

}