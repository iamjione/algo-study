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
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//정점 개수
		M = Integer.parseInt(st.nextToken());//간선 개수
		int R = Integer.parseInt(st.nextToken());//시작 정점
		
		arr = new int[N+1];//답으로 출력할 방문 순서 저장할 배열
		
		adjList = new ArrayList[N+1];//head가 모두 null인 상태
		
		for(int i=1; i<N+1; i++) {//비어있는 ArrayList 만들어주기
			adjList[i] = new ArrayList<Integer>();
		}
		
		int u,v;//간선 정보
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			//무방향 그래프니까 양방향 모두 저장
			adjList[u].add(v);
			adjList[v].add(u);
		}
		
		//내림차순 정렬
		for(int i=1; i<N+1; i++) {
			Collections.sort(adjList[i], Collections.reverseOrder());
		}
		
		bfs(R);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<N+1; i++) sb.append(arr[i]).append('\n');
		System.out.println(sb);

	}
	
	//R번 정점부터 너비우선탐색하는 함수
	private static void bfs(int R) {
		Queue<Integer> q = new ArrayDeque<>();//탐색 대상 결정하기 위한 큐
		boolean[] visited = new boolean[N+1];//방문 표시할 boolean배열
		
		//시작 정점 큐에 넣어주고 방문 표시 해줌
		q.offer(R);
		visited[R] = true;
		
		int curr = 0;//탐색 정점 번호 0으로 초기화
		int i = 1;//방문 순서 1로 초기화
		
		while(!q.isEmpty()) {
			curr = q.poll();//큐에서 poll한 정점을 현재 탐색 정점으로!
			arr[curr] = i++;//배열에 방문순서 저장하고 i++
			
			for(int vertex : adjList[curr]) {//탐색 정점의 인접 정점에 대해서
				if(!visited[vertex]) {//아직 방문하지 않은 정점이면
					q.offer(vertex);//큐에 넣어주고
					visited[vertex] = true;//방문했다고 표시 해줌
				}
			}
		}
	}

}