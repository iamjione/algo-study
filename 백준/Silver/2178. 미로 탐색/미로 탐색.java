import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[][] arr;
	static int[][] cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//미로 세로 길이
		M = Integer.parseInt(st.nextToken());//미로 가로 길이
		arr = new int[N+1][M+1];//미로 입력받을 배열
		cnt = new int[N+1][M+1];//몇번째 칸인지(깊이) 저장 배열
		
		//미로 입력받기
		for(int i=1; i<=N; i++) {
			String s = br.readLine();
			for(int j=1; j<=M; j++) {
				arr[i][j] = s.charAt(j-1)-'0';
			}
		}
		
		bfs();
		System.out.println(cnt[N][M]);
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		
		//상하좌우 탐색을 위한 델타값
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		//(행,열)배열 큐에 넣음
		int[] rc = {1,1};
		q.offer(rc);
		arr[1][1] = 0;//방문 표시하기
		cnt[1][1] = 1;//첫번째 칸의 깊이 = 1
		
		while(!q.isEmpty()) {
			//큐에서 poll한 값 방문
			int r = q.peek()[0];
			int c = q.peek()[1];
			q.poll();
			
			//방문한 곳의 상하좌우 탐색
			for(int i=0; i<4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				//배열 범위 내에 있고 값이 0이 아니면(=가지 못하는 곳이나 이미 방문한 곳이 아니면) 방문하기
				if(0<nr && nr<N+1 && 0<nc && nc<M+1 && arr[nr][nc] != 0) {
					int[] nrnc = {nr,nc};
					q.offer(nrnc);
					arr[nr][nc]=0;//방문 표시하기
					cnt[nr][nc] = cnt[r][c]+1;//탐색 깊이 저장
				}
			}
			
		}
		
	}

}