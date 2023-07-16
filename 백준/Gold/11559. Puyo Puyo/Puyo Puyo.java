import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static char[][] map;//뿌요뿌요 맵
	static boolean end;//게임 종료 여부
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new char[12][6];
		for(int i=0; i<12; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		int cnt = 0;//연쇄 횟수
		
		while(true) {
			end = true;
			bfs();
			fall();
			
			if(end) break;
			
			cnt++;
		}
		System.out.println(cnt);
	}

	//bfs로 뿌요뿌요 터트리기
	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[12][6];
		
		for(int i=0; i<12; i++) {
			for(int j=0; j<6; j++) {
				//빈칸이 아니고 방문하지 않은 곳이면 bfs 실시
				if(map[i][j]!='.' && !visited[i][j]) {
					visited[i][j] = true;//방문체크
					
					ArrayList<int[]> list = new ArrayList<>();//인접한 같은 색의 위치 저장할 리스트
					list.add(new int[] {i,j});
					
					q.add(new int[] {i,j});
					char color = map[i][j];
					
					while(!q.isEmpty()) {	
						int r = q.peek()[0];
						int c = q.peek()[1];
						q.poll();
					
						for(int d=0; d<4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							
							if(nr < 0 || nc < 0 || nr >= 12 || nc >= 6) continue;
							
							if(!visited[nr][nc] && map[nr][nc] == color) {
								q.add(new int[] {nr,nc});
								list.add(new int[] {nr,nc});
								visited[nr][nc] = true;
							}
						}
						
					}
					
					if(list.size()>=4) {
						for(int[] arr : list) map[arr[0]][arr[1]]='.';//빈칸으로 만들기
						end = false;
					}
					
				}
			}
		}
	}

	//아래로 떨어트리기
	private static void fall() {
		for(int i=0; i<6; i++) {
			Queue<Character> q = new ArrayDeque<>();
			for(int j=11; j>=0; j--) {
				//빈칸 아니면 큐에 색 넣고 그 자리 빈칸으로 바꿈
				if(map[j][i]!='.') {
					q.add(map[j][i]);
					map[j][i]='.';
				}
			}
			
			int idx = 11;
			while(!q.isEmpty()) {
				map[idx--][i] = q.poll();
			}
		}
		
	}
	
}