import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static StringBuilder sb = new StringBuilder();//답 저장할 스트링빌더
	static boolean end = false;//스도쿠 완료여부 표시
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new int[9][9];
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sdoku(0,0);//(0,0)부터 스도쿠 시작
		System.out.println(sb);
	}

	private static void sdoku(int r, int c) {
		if(end) return;
		
		if(c==9) {
			sdoku(r+1, 0);
			return;
		}
		
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
		
		if(arr[r][c]==0) {//빈칸이면 1부터 대입해보기
			for(int n=1; n<=9; n++) {
				//같은 행, 같은 열, 3x3칸에 n없는 경우 빈칸에 n넣기
				if(test(r,c,n)) {
					arr[r][c] = n;
					sdoku(r,c+1);
				}
			}
			//스도쿠 하다가 막혔을 때 다시 빈칸으로 만들어주고 되돌아가기!
			arr[r][c] = 0;
			return;
		}
		sdoku(r,c+1);
	}

	private static boolean test(int r, int c, int n) {
		//행 검사
		for(int i=0; i<9; i++) {
			if(arr[r][i]==n) return false;
		}
		//열 검사
		for(int i=0; i<9; i++) {
			if(arr[i][c]==n) return false;
		}
		//3x3칸 검사
		int x = r/3*3;//3x3칸의 시작행
		int y = c/3*3;//3x3칸의 시작열
		for(int i=x; i<x+3; i++) {
			for(int j=y; j<y+3; j++) {
				if(arr[i][j]==n) {
					return false;
				}
			}
		}
		return true;
	}

}