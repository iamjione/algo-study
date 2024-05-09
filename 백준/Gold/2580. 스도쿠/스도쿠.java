import java.io.IOException;
import java.util.Scanner;

public class Main {

	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	static boolean end = false;//스도쿠 완료 여부
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		arr = new int[9][9];
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		sdoku(0,0);
		
		System.out.println(sb.toString());
	}

	private static void sdoku(int r, int c) {
		if(end) return;
		
		r += c/9;
		c = c%9;
		
		if(r==9) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(arr[i][j]+" ");
				}
				sb.append('\n');
			}
			
			end = true;
			
			return;
		}
		
		if(arr[r][c]==0) {//빈칸에 1부터 대입해보기
			for(int i=1; i<=9; i++) {
				if(valid(r,c,i)) {
					arr[r][c] = i;
					sdoku(r,c+1);
					arr[r][c] = 0;
				}
			}			

		}else { // 빈칸 아니면 다음칸으로 이동
			sdoku(r,c+1);	
		}
		
	}

	// (r,c)에 n 넣을 수 있는지 확인하는 메서드
	private static boolean valid(int r, int c, int n) {
		//행, 열 검사
		for(int i=0; i<9; i++) {
			if(arr[r][i]==n) return false;
			if(arr[i][c]==n) return false;
		}

		//3x3칸 검사
		int x = r/3*3;//3x3칸의 시작행
		int y = c/3*3;//3x3칸의 시작열
		
		for(int i=x; i<x+3; i++) {
			for(int j=y; j<y+3; j++) {
				if(arr[i][j]==n) return false;
			}
		}
		
		return true;
	}

}