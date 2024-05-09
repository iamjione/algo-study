import java.util.Scanner;

public class Main {

	static int[][] arr = new int[3][3];
	static int[][] ms = new int[3][3];
	static boolean[] visited = new boolean[10];
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		recur(0, 0, 0);
		
		System.out.println(ans);

	}

	private static void recur(int r, int c, int sum) {
		r += c/3;
		c = c%3;
		
		if(r==3) {
			if(magicSquare()) {
				ans = Math.min(ans, sum);
			}
			
			return;
		}
		
		for(int i=1; i<10; i++) {
			if(visited[i]) continue;
			
			ms[r][c] = i;
			visited[i] = true;
			
			recur(r, c+1, sum+Math.abs(arr[r][c]-i));
			
			visited[i] = false;
		}
	}

	// 매직스퀘어인지 확인
	private static boolean magicSquare() {
		int r = 0; // 행 합
		int c = 0; // 열 합
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				r += ms[i][j];
				c += ms[j][i];
			}
			if(r != 15 || c != 15) return false;
			r = 0;
			c = 0;
		}
		
		int d1 = 0; // 우하향 대각선 합
		int d2 = 0; // 우상향 대각선 합
		
		for(int i=0; i<3; i++) {
			d1 += ms[i][i];
			d2 += ms[i][3-i-1];
		}
		
		if(d1 != 15 || d2 != 15) return false;
		
		return true;
	}

}