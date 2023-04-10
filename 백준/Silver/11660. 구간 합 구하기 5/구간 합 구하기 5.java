import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//표의 크기
		int M = sc.nextInt();//합을 구해야하는 횟수
		
		//숫자 입력받아서 행별 누적합으로 저장하기
		int[][] arr = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				arr[i][j] = arr[i][j-1]+sc.nextInt();
			}
		}
		
		StringBuilder sb = new StringBuilder();//답 저장할 스트링빌더
		
		//부분합 M번 구하기
		for(int i=0; i<M; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int sum = 0;//답으로 출력할 부분합
			for(int j=x1; j<=x2; j++) {
				sum += arr[j][y2]-arr[j][y1-1];//j행의 y1~y2열까지의 합
			}
			sb.append(sum).append('\n');
		}

		System.out.println(sb);
	}

}