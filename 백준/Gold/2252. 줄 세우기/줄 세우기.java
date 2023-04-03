import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());//학생 수
		int M = Integer.parseInt(st.nextToken());//키 비교 횟수
		
        //인접리스트
		ArrayList<Integer>[] adjList = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) adjList[i] = new ArrayList<>();
		//진입차수 배열
		int[] inDegree = new int[N+1];
		//입력받아서 인접리스트에 저장 & 진입차수 카운트
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			
			adjList[v].add(u);
			inDegree[u]++;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i=1; i<N+1; i++) {
			if(inDegree[i]==0) q.add(i);
		}
		
		//답 저장할 스트링 빌더
		StringBuilder sb = new StringBuilder();
		
		while(!q.isEmpty()) {
			//큐에서 원소 하나 꺼내기 & 스트링빌더에 해당 원소 추가
			int curr = q.poll();
			sb.append(curr).append(" ");
			
			for(int u : adjList[curr]) {
				//인접 정점의 진입 차수 1씩 감소
				inDegree[u]--;					
				//진입 차수가 0이 됐다면 큐에 삽입
				if(inDegree[u]==0) {
					q.add(u);
				}
			}
		}
		System.out.println(sb);
	}

}