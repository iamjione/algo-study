import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] visited = new int[100001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//출발 위치
		int K = sc.nextInt();//도착 위치
		
		bfs(N,K);
		//방문순서 1부터 시작하므로 소요 시간 = 방문순서-1
		System.out.println(visited[K]-1);
	}

	private static void bfs(int N, int K) {
		Queue<Integer> q = new ArrayDeque<>();

		q.offer(N);//큐에 출발 위치 넣기
		visited[N]=1;//방문 순서 저장
		
		int curr = -1;//K 0부터 시작이니까 curr -1로 초기화
		while(curr!=K) {
			curr = q.poll();
			
			//큐에서 뽑은 값이 도착 위치일때까지
			//curr-1, curr+1, curr*2 가 0~100000의 범위에있고 아직 방문하지 않았다면
			//큐에 위치 넣어주고 방문 순서 표시하기
			if(curr-1>=0 && visited[curr-1]==0) {
				q.offer(curr-1);
				visited[curr-1]=visited[curr]+1;
			}
			if(curr+1<100001 && visited[curr+1]==0) {
				q.offer(curr+1);
				visited[curr+1]=visited[curr]+1;
			}
			if(curr*2<100001 && visited[curr*2]==0) {
				q.offer(curr*2);
				visited[curr*2]=visited[curr]+1;
			}
		}
		
	}

}