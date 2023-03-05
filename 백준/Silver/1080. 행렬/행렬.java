import java.util.Scanner;

public class Main {

	static int N, M;
	static boolean[][] A, B;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		// 행렬 A 입력 받기
		A = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == '1')
					A[i][j] = true;
			}
		}
		// 행렬 B 입력 받기
		B = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == '1')
					B[i][j] = true;
			}
		}

		int cnt = 0;// 연산 횟수

		for (int i=0; i<=N-3; i++) {
			for (int j=0; j<=M-3; j++) {
				if (A[i][j] != B[i][j]) {
					toggle(i, j);
					cnt++;
				}
			}
		}

		if (isSame())
			System.out.println(cnt);
		else
			System.out.println(-1);

	}

	// 행렬 A와 B가 같은지 다른지 확인하는 함수
	private static boolean isSame() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	// (r,c)를 시작점으로 3*3 부분행렬의 모든 원소 뒤집는 함수
	private static void toggle(int r, int c) {
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				A[i][j] = !A[i][j];
			}
		}
	}

}