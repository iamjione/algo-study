import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//정점 개수
		M = Integer.parseInt(st.nextToken());//간선 개수
		int V = Integer.parseInt(st.nextToken());//시작 정점
		
		//그래프의 간선 정보 저장할 인접 리스트
		adjList = new ArrayList[N+1];//head가 모두 null인 상태
		
		for(int i=1; i<N+1; i++) {//비어있는 ArrayList 만들어주기
			adjList[i] = new ArrayList<Integer>();
		}
		
		int u,v;//간선 정보
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			//양방향
			adjList[u].add(v);
			adjList[v].add(u);
		}
		
		//오름차순 정렬
		for(int i=1; i<N+1; i++) {
			Collections.sort(adjList[i]);
		}
		
		visited = new boolean[N+1];
		dfs(V);
		sb.append('\n');
		visited = new boolean[N+1];
		bfs(V);
		
		System.out.println(sb);

	}
	
	//V번 정점부터 깊이우선탐색하는 함수
	private static void dfs(int V) {
		visited[V] = true;//방문 표시 해주기
		sb.append(V).append(" ");//방문한 정점 번호 스트링빌더에 append
		
		//방문한 정점의 인접 정점 중에 아직 방문하지 않은 정점이 있으면 dfs함수 호출
		for(int vertex : adjList[V]) {
			if(!visited[vertex]) dfs(vertex);
		}
	}

	//V번 정점부터 너비우선탐색하는 함수
	private static void bfs(int V) {
		Queue<Integer> q = new ArrayDeque<>();//탐색 대상 결정하기 위한 큐
		
		//시작 정점 큐에 넣어주고 방문 표시 해줌
		q.offer(V);
		visited[V] = true;
		
		int curr = 0;//탐색 정점 번호
		while(!q.isEmpty()) {
			curr = q.poll();//큐에서 poll한 정점을 현재 탐색 정점으로!
			sb.append(curr).append(" ");//방문한 정점 번호 스트링빌더에 append
			
			for(int vertex : adjList[curr]) {//탐색 정점의 인접 정점에 대해서
				if(!visited[vertex]) {//아직 방문하지 않은 정점이면
					q.offer(vertex);//큐에 넣어주고
					visited[vertex] = true;//방문했다고 표시 해줌
				}
			}
		}
	}

}