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
	static int[] inDegree;
	static boolean[] visited;
	static boolean fail;
	static Stack<Integer> stack;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//가수 수
		int M = Integer.parseInt(st.nextToken());//보조 피디 수
		
		adjList = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) adjList[i] = new ArrayList<>();
		
		inDegree = new int[N+1];//진입차수 배열
		
		int[] arr;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());//보조 피디가 담당한 가수의 수
			arr = new int[num];
			for(int j=0; j<num; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				if(j>=1) {
					adjList[arr[j-1]].add(arr[j]);//인접리스트에 저장
					inDegree[arr[j]]++;//진입차수 카운트
				}
			}
		}
		
		visited = new boolean[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		
		//집입차수가 0인 정점 큐에 넣어줌
		for(int i=1; i<N+1; i++) {
			if(inDegree[i]==0) q.add(i);
		}
	
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			//큐에서 원소 하나 꺼내기 & 스트링빌더에 해당 원소 추가
			int curr = q.poll();
			sb.append(curr).append('\n');
			
			for(int n : adjList[curr]) {
				//인접 정점의 진입 차수 1씩 감소
				inDegree[n]--;					
				//진입 차수가 0이 됐다면 큐에 삽입
				if(inDegree[n]==0) {
					q.add(n);
				}
			}
		}
		
		for(int i=1; i<N+1; i++) {
			if(inDegree[i]!=0) {
				System.out.println(0);
				fail = true;
				break;
			}
		}
		
		if(!fail) System.out.println(sb);
		
	}


}