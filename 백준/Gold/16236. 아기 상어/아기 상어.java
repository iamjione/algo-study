import java.util.*;

public class Main {

	static int N; // N:공간의 크기
	static int[][] arr;
	static Point babyShark;// 아기상어 위치
	static int size = 2;// 아기상어 크기
	static int cnt = 0;// 먹은 물고기 개수
	static int time = 0;// 물고기 잡아 먹을 수 있는 시간
	// 4방 탐색 델타값
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean eat;// 물고기 먹었는지 여부

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 공간의 상태 배열에 저장
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				// 아기 상어 위치 저장
				if (arr[i][j] == 9) {
					arr[i][j] = 0;
					babyShark = new Point(i, j);
				}
			}
		}

		boolean ok = true;
		while (ok) {
			boolean exist = false;// 먹을 수 있는 물고기 존재하는지 여부
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] != 0 && arr[i][j] < size) {
						// 먹을 수 있는 물고기 있으면 bfs실시
						exist = true;
						bfs();
						// 물고기 못먹었으면 탐색 종료
						if (!eat) ok = false;
						break;
					}
				}
			}
			// 먹을 수 있는 물고기 없으면 탐색 종료
			if (!exist) break;
		}
		System.out.println(time);
	}

	private static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.add(babyShark);
		int[][] visited = new int[N][N];//방문 순서(시간) 저장 배열
		visited[babyShark.r][babyShark.c] = 1;
		PriorityQueue<Fish> pq = new PriorityQueue<>();// 먹을 수 있는 물고기 넣을 우선순위 큐
		eat = true;
		
		int r, c, nr, nc, d;
		while (!q.isEmpty()) {
			Point bs = q.poll();
			r = bs.r;
			c = bs.c;
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];

				// 배열 범위 넘어갔거나 더 큰 물고기 있는 칸이거나 방문했던 칸이면 컨티뉴
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || arr[nr][nc] > size || visited[nr][nc] != 0) continue;
				
				// 아기상어보다 더 작은 물고기 있는 경우
				if (arr[nr][nc] != 0 && arr[nr][nc] < size) {
					// 우선순위큐에 위치,거리 저장
					visited[nr][nc] = visited[r][c] + 1;
					pq.add(new Fish(nr, nc,visited[nr][nc]));
				} else {
					// 빈칸이거나 크기 작은 물고기 있는 경우 그 칸으로 이동
					visited[nr][nc] = visited[r][c] + 1;
					q.add(new Point(nr, nc));
				}
			}
		}
		// 먹을 수 있는 물고기 없으면 eat=false
		if (pq.isEmpty()) {
			eat = false;
			return;
		}
		
		// 먹을 수 있는 물고기들 중 제일 우선순위에 있는 물고기 먹기
		Fish f = pq.poll();
		arr[f.r][f.c] = 0;
		cnt++;
		// 아기상어 위치 저장
		babyShark = new Point(f.r, f.c);
		time += f.d - 1;
		// 크기만큼 물고기 잡아먹었으면 사이즈 1 증가하고 카운트 0으로 초기화
		if (size == cnt) {
			size++;
			cnt = 0;
		}
		return;
		
	}

	private static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	private static class Fish implements Comparable<Fish> {
		int r, c, d;

		public Fish(int r, int c,int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

		// 거리 ->위쪽->왼쪽 순으로 정렬
		@Override
		public int compareTo(Fish o) {
			if(this.d==o.d) {
				if (this.r == o.r) return this.c - o.c;
				return this.r - o.r;				
			}
			return this.d-o.d;
		}
	}

}