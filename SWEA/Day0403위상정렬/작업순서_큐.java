package Day0403위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 작업순서_큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int tc=1; tc<=10; tc++) {
			st = new StringTokenizer(br.readLine());
			int V =Integer.parseInt(st.nextToken());// 정점의 개수
			int E =Integer.parseInt(st.nextToken());// 간선의 개수
			
			ArrayList<Integer>[] adjList = new ArrayList[V+1];
			for(int i=1; i<V+1; i++) adjList[i] = new ArrayList<>();
			
			int[] inDegree = new int[V+1];//진입 차수 배열
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				adjList[start].add(end);
				inDegree[end]++;
			}
			
			Queue<Integer> q = new ArrayDeque<>();
			
			//집입차수가 0인 정점 큐에 넣어줌
			for(int i=1; i<V+1; i++) {
				if(inDegree[i]==0) q.add(i);
			}
			
			//답 저장할 스트링 빌더
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);
			
			while(!q.isEmpty()) {
				//큐에서 원소 하나 꺼내기 & 스트링빌더에 해당 원소 추가
				int curr = q.poll();
				sb.append(" ").append(curr);
				
				for(int n : adjList[curr]) {
					//인접 정점의 진입 차수 1씩 감소
					inDegree[n]--;					
					//진입 차수가 0이 됐다면 큐에 삽입
					if(inDegree[n]==0) {
						q.add(n);
					}
				}
			}
			System.out.println(sb);
		}//tc
	}
}