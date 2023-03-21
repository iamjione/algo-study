import java.util.Scanner;

public class Main {

	static int N;
	static int[][] arr;
	static boolean[] check;
	static int min;//능력 차이 최소값

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();// 사람 수
		arr = new int[N][N];//능력치 배열

		check = new boolean[N];
			
		// 능력치 시너지 입력받아서 배열에 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		min = Integer.MAX_VALUE;//최소값 초기화
		combination(0,0);

		System.out.println(min);
		
	}

	private static void combination(int idx, int cnt) {

		// base case
		if (cnt == N / 2) {// N/2개를 다 뽑은 경우
			int sumA = 0;
			int sumB = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i != j) {
						if(check[i]==true && check[j]==true) sumA += arr[i][j];
						else if(check[i]==false && check[j]==false) sumB += arr[i][j];
					}
				}
			}
			
			int diff = Math.abs(sumA-sumB);//두 팀의 능력치 차이
			if(min>diff) min = diff;
			
			return;
		}
		
		if (idx == N) {// 경우의 수를 다 고려한 경우
			return;
		}

		// recursive case
		check[idx] = true;
		combination(idx + 1, cnt + 1);// 이번 사람 선택했고 다음 사람 판단하러 ㄱㄱ
		check[idx] = false;
		combination(idx + 1, cnt);// 이번 사람 선택 안 했고 다음 사람 판단하러 ㄱㄱ
		
		
	}

}