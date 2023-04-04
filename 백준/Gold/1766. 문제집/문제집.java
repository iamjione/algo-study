import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());//문제의 수
		int M = Integer.parseInt(st.nextToken());//문제 정보 수
		
		//문제 정보 입력받아서 인접리스트에 저장 && 진입차수 카운트
		ArrayList<Integer>[] adjList = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) adjList[i] = new ArrayList<>();
		int[] inDegree= new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			
			adjList[v].add(u);
			inDegree[u]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		//진입차수 0인 문제번호 우선순위큐에 넣어줌
		for(int i=1; i<N+1; i++) {
			if(inDegree[i]==0) pq.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!pq.isEmpty()) {
			//우선순위큐에서 원소 하나 꺼내기
			int curr = pq.poll();
			sb.append(curr+" ");
			
			for(int n : adjList[curr]) {
				//인접 정점의 진입 차수 1씩 감소
				inDegree[n]--;					
				//진입 차수가 0이 됐다면 우선순위큐에 삽입
				if(inDegree[n]==0) {
					pq.add(n);
				}
			}
		}
		
		System.out.println(sb);
		
	}

}