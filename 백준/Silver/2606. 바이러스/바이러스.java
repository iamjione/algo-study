import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int N,M;
	static ArrayList<Integer>[] adjlist;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//컴퓨터 수
		M = sc.nextInt();//직접 연결되어 있는 컴퓨터 쌍의 수
		
		visited = new boolean[N+1];//방문 배열
		
		adjlist = new ArrayList[N+1];//인접 행렬 리스트
		
		//리스트 null->빈 리스트로 초기화
		for(int i=0; i<N+1; i++) {
			adjlist[i] = new ArrayList<>();
		}
		
		//연결되어있는 컴퓨터의 쌍 입력받아서 인접행렬 리스트에 추가
		for(int i=0; i<M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			adjlist[u].add(v);
			adjlist[v].add(u);
		}
		
		dfs(1);//1을 시작 정점으로 dfs 시행
		
		//방문 배열의 2번 인덱스부터 순회하면서 방문한 정점의 개수 카운트
		int cnt = 0;
		for(int i=2; i<N+1; i++) {
			if(visited[i]==true) cnt++;
		}
		
		System.out.println(cnt);

	}

	private static void dfs(int i) {
		visited[i] = true;
		
		for(int vertex : adjlist[i]) {
			if(visited[vertex]==false) dfs(vertex);
		}
		
	}

}