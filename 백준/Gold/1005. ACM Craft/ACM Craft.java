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
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());//테스트케이스
		for(int tc=1; tc<=T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());//건물 개수
			int K = Integer.parseInt(st.nextToken());//선물 순서 규칙 개수
			
			//각 건물을 건설하는데 걸리는 시간 arr 배열에 저장
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N+1];
			for(int i=1; i<N+1; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			//건설 순서 입력받아서 인접리스트에 저장 && 진입차수 카운트
			ArrayList<Integer>[] adjList = new ArrayList[N+1];
			for(int i=1; i<N+1; i++) adjList[i] = new ArrayList<>();
			int[] inDegree= new int[N+1];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken());
				int u = Integer.parseInt(st.nextToken());
				
				adjList[v].add(u);
				inDegree[u]++;
			}
			
			//승리하기 위해 지어야하는 건물 번호
			int end = Integer.parseInt(br.readLine());
			
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
				
				//만약 큐에서 뽑은 원소가 승리하기 위해 지어야하는 건물 번호라면 
				//이 이후는 생각 안 해도 되니까 반복문 끝내기
				if(curr==end) break;
				
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
			
			System.out.println(res[end]);
			
		}//tc
	}
}