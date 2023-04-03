import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] adjList;
	static int[] inDegree, visited;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//과목 수
		int M = Integer.parseInt(st.nextToken());//선수 조건 수

		adjList = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) adjList[i] = new ArrayList<>();
		
		inDegree = new int[N+1];//진입 차수 배열
		visited = new int[N+1];//방문 순서(=최소 학기)배열
		stack = new Stack<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adjList[start].add(end);
			inDegree[end]++;
		}

		Queue<Integer> q = new ArrayDeque<>();
		
		//집입차수가 0인 정점 큐에 넣어줌 && 방문순서 1 저장
		for(int i=1; i<N+1; i++) {
			if(inDegree[i]==0) {
				q.add(i);
				visited[i] = 1;
			}
		}
		
		while(!q.isEmpty()) {
			//큐에서 원소 하나 꺼내기 & 스트링빌더에 해당 원소 추가
			int curr = q.poll();
			
			for(int n : adjList[curr]) {
				//인접 정점의 진입 차수 1씩 감소
				inDegree[n]--;					
				//진입 차수가 0이 됐다면 큐에 삽입 && 방문순서 저장
				if(inDegree[n]==0) {
					q.add(n);
					visited[n] = visited[curr]+1;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<N+1; i++) {
			sb.append(visited[i]).append(" ");
		}
		System.out.println(sb);
	}

}