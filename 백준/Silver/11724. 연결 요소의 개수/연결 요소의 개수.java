import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int N,M;
	static ArrayList<Integer>[] adjlist;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//정점 수
		M = sc.nextInt();//간선 수
		
		visited = new boolean[N+1];//방문 배열
		
		adjlist = new ArrayList[N+1];//인접 행렬 리스트
		
		//리스트 null->빈 리스트로 초기화
		for(int i=0; i<N+1; i++) {
			adjlist[i] = new ArrayList<>();
		}
		
		//인접행렬 입력아서 인접행렬 리스트에 저장
		for(int i=0; i<M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			adjlist[u].add(v);
			adjlist[v].add(u);
		}
		
		int cnt = 0;//연결요소 개수
		
		for(int i=1; i<N+1; i++) {
			if(visited[i]==false) {
				cnt++;
				dfs(i);
			}
		}
		
		System.out.println(cnt);

	}

	private static void dfs(int i) {
		visited[i] = true;//방문체크 해줌
		
		//인접 정점 중 아직 방문하지 않은 곳 있다면 방문하기
		for(int vertex:adjlist[i]) {
			if(visited[vertex]==false) dfs(vertex);
		}
		
	}

}