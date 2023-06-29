import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int[][] sudoku = new int[9][9];
	static List<int[]> blanks = new ArrayList<>();//빈칸의 (r,c) 저장할 리스트
	static boolean end=false;//빈칸 다 채웠는지 여부

	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);		
		for(int i=0; i<9; i++) {
			String line = sc.next();
			for(int j=0; j<9; j++) {
				sudoku[i][j] = line.charAt(j)-'0';
				if(sudoku[i][j]==0) blanks.add(new int[] {i,j});//빈칸이면 리스트에 저장
			}
		}
		
		//첫번째 빈칸부터 스도쿠 시작
		doSudoku(0);
		
		//출력
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(sudoku[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	private static void doSudoku(int idx) {
		//빈칸 다 채웠으면  end를 true로 바꾸고 리턴
		if(idx == blanks.size()) {
			end = true;
			return;
		}
		
		int r = blanks.get(idx)[0];
		int c = blanks.get(idx)[1];
		
		for(int i=1; i<=9; i++) {
			if(validate(r,c,i)) {
				sudoku[r][c]=i;
				doSudoku(idx+1);
				if(end) break;
				sudoku[blanks.get(idx+1)[0]][blanks.get(idx+1)[1]]=0;//원상복구
			}
		}
		
	}

	private static boolean validate(int r, int c, int num) {
		//행 체크
		for(int i=0; i<9; i++) {
			if(sudoku[r][i]==num) return false;
		}
		//열 체크
		for(int i=0; i<9; i++) {
			if(sudoku[i][c]==num) return false;
		}
		//3*3 사각형 체크
		for(int i=r/3*3; i<r/3*3+3; i++) {
			for(int j=c/3*3; j<c/3*3+3; j++) {
				if(sudoku[i][j]==num) return false;
			}
		}
		return true;
	}

}