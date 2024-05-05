import java.util.Scanner;

public class Main {
	
	static int N; // 물감 개수
	static int[][] colors; // 갖고 있는 물감들의 RGB
	static int[] gomduri = new int[3]; // 곰두리색의 RGB
	static int[][] sel; // 선택한 물감들의 RGB
	static int answer = 1000; // 곰두리색과 문두리색의 차이
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		colors = new int[N][3];
		for(int i=0; i<N; i++) {
			for(int j=0; j<3; j++) {
				colors[i][j] = sc.nextInt();				
			}
		}
		
		for(int i=0; i<3; i++) {
			gomduri[i] = sc.nextInt();			
		}
		
		int limit = Math.min(N, 7); // 최대 7개 색 선택 가능
		sel = new int[limit][3];
		
		// 2개부터 limit개 선택해보기
		for(int i=2; i<=limit; i++) {
			selectColors(0, i, 0);			
		}
		
		System.out.println(answer);
	}

	private static void selectColors(int idx, int total, int start) {
		if(idx==total) {
			updateAnswer(idx);
			return;
		}
		
		for(int i=start; i<N; i++) {
			for(int j=0; j<3; j++) {
				sel[idx][j] = colors[i][j];
			}
			
			selectColors(idx+1, total, i+1);
		}
		
	}

	private static void updateAnswer(int idx) {
		int sum;
		int diff = 0;
		for(int i=0; i<3; i++) {
			sum = 0;
			for(int j=0; j<idx; j++) {
				sum += sel[j][i];
			}
			diff += Math.abs(gomduri[i]-sum/idx);
		}
		
		answer = Math.min(answer, diff);
		
	}

}