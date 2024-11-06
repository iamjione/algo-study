import java.util.*;

public class Main {
	
	static int N;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int ans = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 컴퓨터 수
		int M = sc.nextInt(); // 연결된 컴퓨터 쌍의 수
		
		adjList = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		int s, e;
		for(int i=0; i<M; i++) {
			s = sc.nextInt();
			e = sc.nextInt();
			
			adjList[s].add(e);
			adjList[e].add(s);
		}
		
		visited = new boolean[N+1];
		
		dfs(1);
		
		System.out.println(ans);

	}
	
	static void dfs(int curr) {
		visited[curr] = true;
		ans++;
		
		for(int next : adjList[curr]) {
			if(visited[next]) continue;
			
			dfs(next);
		}
	}

}