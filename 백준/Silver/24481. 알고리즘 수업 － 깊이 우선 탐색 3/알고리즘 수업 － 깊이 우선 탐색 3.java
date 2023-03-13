import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		int u,v;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			adjList[u].add(v);
			adjList[v].add(u);
		}
		
		//오름차순 정렬
		for(int i=1; i<N+1; i++) {
			Collections.sort(adjList[i]);
		}
		
		visited = new boolean[N+1];//방문 표시할 배열
		ans = new int[N+1];//깊이 저장할 배열
		for(int i=1; i<N+1; i++) ans[i] = -1;//깊이 -1로 초기화
		
		ans[R] = 0;//시작 깊이 배열에 저장
		dfs(R);
		for(int i=1; i<N+1; i++) System.out.println(ans[i]);
		
	}

	private static void dfs(int R) {
		visited[R] = true;//방문 표시 해주고
		
		//인접 정점 중 아직 방문하지 않은 곳 있다면 깊이 배열에 저장해주고 dfs함수 호출
		for(int vertex : adjList[R]) {
			if(!visited[vertex]) {
				ans[vertex] = ans[R]+1;//나의 깊이는 나를 호출한 정점의 깊이+1
				dfs(vertex);
			}
		}
		
	}

}