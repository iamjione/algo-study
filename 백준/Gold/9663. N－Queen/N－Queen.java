import java.util.Scanner;

public class Main {
	
	static int N,cnt;
	static boolean[] col;//열
	static boolean[] d1;//대각선
	static boolean[] d2;//역대각선

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//체스판 크기
		N = sc.nextInt();
		
		//배열 초기화
		col = new boolean[N];
		d1 = new boolean[2*N-1];
		d2 = new boolean[2*N-1];
		
		//카운트 초기화
		cnt = 0;
		
		nQueen(0);
		System.out.println(cnt);

	}

	private static void nQueen(int r) {
		//마지막 행까지 다 놨으면 카운트해주고 리턴
		if(r==N) {
			cnt++;
			return;
		}
				
		for(int c=0; c<N; c++) {//출발점 (0,0)~(0,N-1)
			//(r,c)가 퀸을 놓을 수 있는 자리인지 확인
			if(col[c]==true || d1[r-c+N-1]==true || d2[r+c]==true) continue;
					
			//놓은 위치 표시해주기
			col[c]= true;
			d1[r-c+N-1] = true;
			d2[r+c] = true;
			nQueen(r+1);//재귀 함수 호출
			//원상복구
			col[c]= false;
			d1[r-c+N-1] = false;
			d2[r+c] = false;
		}
	}

}