import java.util.Scanner;

public class Main {
	
	static int N,M;
	static char[][] maze;
	static boolean[][] visited;
	static int[][] escape;//탈출 성공==1,실패==-1
	static int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		maze = new char[N][M];
		for(int i=0; i<N; i++) maze[i] = sc.next().toCharArray();
		
		escape = new int[N][M];
		visited = new boolean[N][M];

		int cnt = 0;//탈출 가능한 칸의 수
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(Escape(i,j)) cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static boolean Escape(int r, int c) {		
		//탈출 성공
		if(r<0 || r>=N || c<0 || c>=M) return true;

		//이전에 탈출 성공했던 칸이면 탈출 성공
		if(escape[r][c]==1) return true;
		
		//방문했던 곳 또 방문하면 탈출 실패
		if(visited[r][c]) return false;
		
		visited[r][c] = true;//방문체크
		
		//이동
		int idx;
		if(maze[r][c]=='U') idx = 0;
		else if(maze[r][c]=='D') idx = 1;
		else if(maze[r][c]=='L') idx = 2;
		else idx = 3;
		boolean res = Escape(r+d[idx][0], c+d[idx][1]);

		//escape배열에 성공/실패 여부 표시
		if(res) escape[r][c] = 1;
		else escape[r][c] = -1;
		
		return res;
	}

}