import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//건물 수
		
		//인접리스트
		ArrayList<Integer>[] adjList = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) adjList[i] = new ArrayList<>();
		int[] arr = new int[N+1];//건물 짓는데 걸리는 시간
		int[] inDegree= new int[N+1];//진입차수
		
		StringTokenizer st;		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			//i번 건물 건설하는데 걸리는 시간 arr배열에 저장
			arr[i] = Integer.parseInt(st.nextToken());
			
			//-1 나오기 전까지 먼저 지어야하는 건물 입력받아서 인접리스트에 저장
			while(true) {
				int num = Integer.parseInt(st.nextToken());
				if(num != -1) {
					adjList[num].add(i);
					inDegree[i]++;
				}
				else break;
			}
		}
		
		Queue<Integer> q = new ArrayDeque<>();//위상정렬에 사용할 큐
		int[] res = new int[N+1];//각 건물 건설하기 위해 총 몇 시간 걸리는 지 저장할 배열
		
		//집입차수가 0인 정점 큐에 넣어줌 && 건설 시간 배열에 저장
		for(int i=1; i<N+1; i++) {
			if(inDegree[i]==0) {
				q.add(i);
				res[i] = arr[i];
			}
		}
		
		while(!q.isEmpty()) {
			//큐에서 원소 하나 꺼내기
			int curr = q.poll();
			
			for(int n : adjList[curr]) {
				//인접 정점의 진입 차수 1씩 감소
				inDegree[n]--;					
				//진입 차수가 0이 됐다면 큐에 삽입
				if(inDegree[n]==0) {
					q.add(n);
				}
				//최대 건설 시간 갱신
				res[n] = Math.max(res[n], res[curr]+arr[n]);
			}
		}
		
		for(int i=1; i<N+1; i++) {
			System.out.println(res[i]);
		}
	}
}