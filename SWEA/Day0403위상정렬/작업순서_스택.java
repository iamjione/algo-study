package Day0403위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 작업순서_스택 {

	static int V;
	static ArrayList<Integer>[] adjList;
	static int[] inDegree;
	static boolean[] visited;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int tc=1; tc<=10; tc++) {
			st = new StringTokenizer(br.readLine());
			V =Integer.parseInt(st.nextToken());// 정점의 개수
			int E =Integer.parseInt(st.nextToken());// 간선의 개수
			
			adjList = new ArrayList[V+1];
			for(int i=1; i<V+1; i++) adjList[i] = new ArrayList<>();
			
			inDegree = new int[V+1];//진입 차수 배열
			visited = new boolean[V+1];//방문 표시 배열
			stack = new Stack<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				adjList[start].add(end);
				inDegree[end]++;
			}
			
			//진입차수가 0인 노드에 대해 DFS 시행
			for(int i=1; i<V+1; i++) {
				if(inDegree[i]==0) TopologicalSort(i);
			}
			
			//스택에 있는 값 pop한 순서대로 스트링빌더에 저장
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);
			while(!stack.isEmpty()) {
				sb.append(" ").append(stack.pop());
			}
			
			System.out.println(sb);
			
		}//tc
	}

	private static void TopologicalSort(int v) {
		visited[v] = true;//방문 표시 해주기
		
		//인접 정점 중 방문하지 않은 곳 있으면 재귀 호출
		for(int u : adjList[v]) {
			if(visited[u]==false) TopologicalSort(u);
		}
		//스택에 넣어줌
		stack.push(v);
	}
}