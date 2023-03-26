import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int L,W;
	static char[][] arr;
	static boolean[][] visited;
	static int[][] time;//이동시간 배열
	static int max = 0;//최대 이동시간
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());//새로 크기
		W = Integer.parseInt(st.nextToken());//가로 크기
		
		arr = new char[L][W];
		for(int i=0; i<L; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		//2차원 배열 순회하면서 육지(L)만나면 bfs실시
		for(int i=0; i<L; i++) {
			for(int j=0; j<W; j++) {
				if(arr[i][j]=='L') {
					visited = new boolean[L][W];
					time = new int[L][W];
					bfs(i,j);
				}
			}
		}
		System.out.println(max);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		
		//상하좌우 탐색을 위한 델타값
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		//(행,열)배열 큐에 넣음
		q.offer(new int[] {r,c});
		visited[r][c] = true;//방문 표시하기
		time[r][c] = 0;//이동 시간
		
		while(!q.isEmpty()) {
			//큐에서 poll한 값 방문
			r = q.peek()[0];
			c = q.peek()[1];
			q.poll();
			
			//방문한 곳의 상하좌우 탐색
			for(int i=0; i<4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				//배열 범위 벗어나면 컨티뉴
				if(0>nr || nr>=L || 0>nc || nc>=W) continue;
				//바다거나 방문한 땅이면 컨티뉴
				if(arr[nr][nc] == 'W' || visited[nr][nc]) continue;
				
				int[] nrnc = {nr,nc};
				q.offer(nrnc);
				visited[nr][nc]=true;//방문 표시하기
				time[nr][nc] = time[r][c]+1;//이동 시간 저장
			}			
		}
		//마지막에 방문한 곳의 이동시간이 max보다 크면 max 갱신
		if(time[r][c]>max) max = time[r][c];
	}

}