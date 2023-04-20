import java.util.Scanner;

public class Main {
	
	static int R, C;
	static boolean[] visited = new boolean[26];//A~Z까지 방문체크 배열
	static char[][] arr;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int max=0;//이동한 최대 칸 수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();//행
		C = sc.nextInt();//열
		
		//배열 입력받기
		arr = new char[R][C];
		for(int i=0; i<R; i++) {
			arr[i] = sc.next().toCharArray();
		}
		
		DFS(0,0,1);
		System.out.println(max);
	}

	private static void DFS(int r, int c, int cnt) {
		//해당 알파벳 방문체크 해주기
		visited[arr[r][c]-65] = true;
		
		//지나온 칸이 max보다 크면 max값 갱신
		if(cnt>max) max = cnt;
		
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			//배열 벗어나거나 이미 지나온 알파벳이면 컨티뉴
			if(nr<0 || nr>=R || nc<0 || nc>=C || visited[arr[nr][nc]-65]) continue;
			
			//(nr,nc)를 방문할 수 있으면 cnt 하나 늘려주고 DFS 실행
			DFS(nr,nc,cnt+1);
			visited[arr[nr][nc]-65] = false;//원상복구
		}
		
	}

}