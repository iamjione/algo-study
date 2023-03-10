import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int ans = -1;//답으로 출력할 변수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//전체 사람 수
		//촌수를 계산해야하는 두 사람 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {//비어있는 ArrayList만들어주기
			adjList[i] = new ArrayList<Integer>();
		}

		int M = Integer.parseInt(br.readLine());//부모 자식간의 관계 수
		for(int i=0; i<M; i++) {
			//부모자식 관계인 두 사람 입력받기
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			//인접리스트에 저장
			adjList[x].add(y);
			adjList[y].add(x);
		}
		
		visited = new boolean[N+1];//방문 체크할 배열
		dfs(p1, p2, 0);
		System.out.println(ans);
	}
	
	//p1: 시작 정점 p2: 끝 정점, cnt: 촌수
	private static void dfs(int p1, int p2, int cnt) {
		//p2에 도달했으면 답을 cnt로 갱신해주고 재귀 종료
		if(p1==p2) {
			ans = cnt;
			return;
		}
		
		//p1 방문 표시해주기
		visited[p1] = true;
		//p1의 인접 정접들 중에 방문하지 않은 정점이 있다면 
		//그 정점에서 촌수 + 1 해서 다시 dfs함수 호출
		for(int person : adjList[p1]) {
			if(!visited[person]) dfs(person, p2, cnt+1);
		}
		
	}

}