import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] arr;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] sum;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());//지도 크기
			if(N==0) {
				break;//0이면 종료
			}
			else {
				//도둑 루피 크기 입력받아서 배열에 저장
				arr = new int[N][N];
				for(int i=0; i<N; i++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					for(int j=0; j<N; j++) {
						arr[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				
				sum = new int[N][N];//각 칸까지 오는데 잃는 금액의 합의 최소값 저장할 배열
				
				//arr 배열 최대값으로
				for(int i=0; i<N; i++) {
					Arrays.fill(sum[i], Integer.MAX_VALUE);
				}
				sum[0][0] = arr[0][0];//시작점은 arr[0][0]으로 초기화
				
				visited = new boolean[N][N];//방문 표시할 배열
				
				dijkstra(new Node(0,0,arr[0][0]));
				
				System.out.printf("Problem %d: %d",tc++,sum[N-1][N-1]);
				System.out.println();
			}
		}
	}

	private static void dijkstra(Node node) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(node);
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int r = curr.r;
			int c = curr.c;
			visited[r][c] = true;
			
			for(int i=0; i<4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				
				//배열 범위 벗어나면 컨티뉴
				if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
				//이미 방문한 곳이면 컨티뉴
				if(visited[nr][nc]) continue;
				
				sum[nr][nc] = Math.min(sum[nr][nc], sum[r][c]+arr[nr][nc]);
				Node next = new Node(nr,nc,sum[nr][nc]);
				pq.add(next);
			}
		}
		
	}
	
	static class Node implements Comparable<Node> {
		int r, c, loss;
		public Node(int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.loss = depth;
		}
		@Override
		public int compareTo(Node o) {
			return this.loss-o.loss;
		}
	}

}