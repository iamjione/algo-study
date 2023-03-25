import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//헛간 개수
		int M = Integer.parseInt(st.nextToken());//양방향 길 개수
		
		//헛간 1~N번이므로 리스트 크기  N+1로!
		ArrayList<int[]>[] adjList = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {//비어있는 ArrayList 만들어주기
			adjList[i] = new ArrayList<int[]>();
		}

		int start, end, cost;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());//도착점
			end = Integer.parseInt(st.nextToken());//출발점
			cost = Integer.parseInt(st.nextToken());//여물의 비용

			//양방향으로 저장해줌
			adjList[end].add(new int[] {start,cost});
			adjList[start].add(new int[] {end,cost});
		}
		
		int[] distance = new int[N+1];//출발 정점에서 idx까지의 최소 비용
		Arrays.fill(distance, Integer.MAX_VALUE);//최소값 갱신 로직 반영해야하므로 큰 값으로 초기화
		boolean[] visited = new boolean[N+1];//경유지로 고려됐는지 여부
		distance[1] = 0;//출발점에서 출발점까지의 비용 0
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			//비용기준 오름차순 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
        
		pq.add(new int[]{1,0});//출발점 우선순위큐에 넣어줌
		
		int min, current;
		while(!pq.isEmpty()) {
			//step1 : 경유지로 처리되지 않은 정점 중 출발지에서 가장 가까운 정점 선택
			current = pq.peek()[0];
			min = pq.peek()[1];
			pq.poll();
			
			if(visited[current]) continue;//이미 경유지로 고려했던 곳이면 컨티뉴
			else visited[current] = true;//고려하지 않았던 곳이면 방문체크해주고 step2로!
			
			//step2 : 위에서 선택된 정점을 경유지로 해서 갈 수 있는 다른 미방문 인접정점과의 비용 최소값 갱신
			for(int j=0; j<adjList[current].size(); j++) {
				int next = adjList[current].get(j)[0];//current의 인접 정점
				if(visited[next]) continue;
				cost = adjList[current].get(j)[1];//current에서 인접정점 next로 갈 때의 비용
				//기존의 비용이랑 비교해서 최단 비용 갱신
				distance[next] = Math.min(distance[next], min+cost);
				pq.add(new int[] {next, distance[next]});
			}	
			
			
		}
		
		System.out.println(distance[N]);

	}

}