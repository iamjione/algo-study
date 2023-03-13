import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] visited = new int[100001];
	static int min=100001;//최단 시간
	static int cnt = 0;//최단시간으로 K에 도달하는 경우의 수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//출발 위치
		int K = sc.nextInt();//도착 위치
		
		bfs(N,K);

		System.out.println(min);
		System.out.println(cnt);
	}

	private static void bfs(int N, int K) {
		Queue<Integer> q = new ArrayDeque<>();

		q.offer(N);//큐에 출발 위치 넣기
		visited[N]=1;//방문 순서 표시
		
		int curr=0;
		while(!q.isEmpty()) {
			curr = q.poll();
			
			//min보다 오래 걸리는 경우 return (방문순서-1==소요시간)
			if(visited[curr]-1>min) return;
			
			//K에 도착했을 때 도착까지 걸린 시간 min에 저장하고 cnt++
			if(curr==K) {
				min = visited[curr]-1;
				cnt++;
			}
						
			//탐색 위치가 배열의 범위 내에 있고 아직 방문하지 않았거나 최단시간으로 방문한 경우
			//큐에 탐색위치 넣어주고 방문 순서 표시
			if(curr-1>=0 && (visited[curr-1]==0||visited[curr-1]==visited[curr]+1)) {
				q.offer(curr-1);
				visited[curr-1]=visited[curr]+1;
			}
			if(curr+1<100001 && (visited[curr+1]==0||visited[curr+1]==visited[curr]+1)) {
				q.offer(curr+1);
				visited[curr+1]=visited[curr]+1;
			}
			if(curr*2<100001 && (visited[curr*2]==0||visited[curr*2]==visited[curr]+1)) {
				q.offer(curr*2);
				visited[curr*2]=visited[curr]+1;
			}
		}
		
	}

}