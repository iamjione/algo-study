import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static double[][] arr;
	
	static class Edge implements Comparable<Edge>{
		int st, ed;
		double w;

		public Edge(int st, int ed, double w) {
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int N =sc.nextInt();//섬의 개수
			
		arr = new double[N][2];//섬 좌표 저장할 배열
			
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextDouble();//i섬의 x좌표			
			arr[i][1] = sc.nextDouble();//i섬의 y좌표
		}
				
		//인접리스트 
		List<Edge>[] adjList = new ArrayList[N];
		for(int i = 0 ; i<N; i++) {
			adjList[i] = new ArrayList<>();
		}
			
		//인접리스트에 간선정보 저장
		for(int i=0 ; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				double W = cost(i,j);//비용
				adjList[i].add(new Edge(i, j, W));
				adjList[j].add(new Edge(j, i, W));					
			}
		}
			
		boolean[] visited = new boolean[N];//방문 표시할 배열
			
		PriorityQueue<Edge> pq = new PriorityQueue<>();
			
		//임의의 정점 0 부터 방문 시작
		visited[0] = true;
		pq.addAll(adjList[0]);
			
		int cnt = 1; //확보한 정점의 개수 
		double ans = 0;//답으로 출력할 최소 비용
			
		while(cnt != N) {
			Edge e = pq.poll();
			if(visited[e.ed]) continue;
				
			ans += e.w;
			pq.addAll(adjList[e.ed]);
			visited[e.ed] = true;
			cnt++;
		}
			
		System.out.printf("%.2f",ans);
		
	}
	
	//i섬과 j섬의 연결 비용
	private static double cost(int i, int j) {	
		return Math.sqrt((Math.pow(arr[i][0]-arr[j][0],2)+Math.pow(arr[i][1]-arr[j][1],2)));
	}

}