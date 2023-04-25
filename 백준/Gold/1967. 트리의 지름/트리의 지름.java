import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int max = 0;//최장 거리
	static int maxNode = 0;//최장거리 노드 번호
	static ArrayList<Node>[] list;
	static boolean[] visited;
	
	static class Node {
		int n, w;

		public Node(int n, int w) {
			super();
			this.n = n;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//노드 개수
		
		//인접 리스트 만들고 초기화해줌
		list = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		//간선 정보 입력받기
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());//부모 노드
			int child = Integer.parseInt(st.nextToken());//자식 노드
			int weight = Integer.parseInt(st.nextToken());//간선의 가중치
			
			list[parent].add(new Node(child,weight));
			list[child].add(new Node(parent,weight));
		}
		
		//////루트 노드에서 가장 먼 노드가 무조건 트리의 지름을 이루는 노드 중 하나임!!
		
		//루트 로드는 무조건 1이니까 1에서 부터 dfs실시
		visited = new boolean[N+1];
		dfs(1,0);
		//루트 노드에서 가장 먼 노드에서부터 dfs실시
		visited = new boolean[N+1];
		dfs(maxNode,0);			

		System.out.println(max);
	}
	
	private static void dfs(int i, int sum) {
		visited[i] = true;//리스트에 양방향으로 저장했으니까 방문체크해줌
		
		//i의 인접 노드에 대해서
		for(Node next:list[i]) {
			//이미 방문한 곳이면 컨티뉴
			if(visited[next.n]) continue;
			//방문하지 않았으면 dfs
			dfs(next.n,sum+next.w);
		}
		
		//더이상 갈 곳없으면 최장거리 갱신 && 노드 번호 저장
		if(sum>max) {
			max = sum;
			maxNode = i;
		}
		return;	
	}

}