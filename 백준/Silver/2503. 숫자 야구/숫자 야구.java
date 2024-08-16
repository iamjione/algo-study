import java.util.Scanner;

public class Main {

	static int N;
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 질문 횟수
		
		arr = new int[N][3];
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt(); // 숫자
			arr[i][1] = sc.nextInt(); // 스트라이크 개수
			arr[i][2] = sc.nextInt(); // 볼 개수
		}
		
		int cnt = 0;
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				if(i==j) continue;
				for(int k=1; k<=9; k++) {
					if(i==k || j==k) continue;
					//ijk가 답이 될 수 있으면 카운트
					if(valid(i,j,k)) cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}

	private static boolean valid(int a, int b, int c) {
		int x, y, z, strike, ball;
		for(int i=0; i<N; i++) {
			x = arr[i][0]/100;
			y = (arr[i][0]%100)/10;
			z = arr[i][0]%10;
			
			// 스트라이크 수 확인하기
			strike = 0;
			
			if(a==x) strike++;
			if(b==y) strike++;
			if(c==z) strike++;
			
			if(strike != arr[i][1]) return false;
			
			// 볼 수 확인하기
			ball = 0;
			
			if(a==y || a==z) ball++;
			if(b==x || b==z) ball++;
			if(c==x || c==y) ball++;
			
			if(ball != arr[i][2]) return false;
		}
		
		return true;
	}

}