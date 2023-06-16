import java.util.*;

public class Main {
	
	static int[] p;//1~N번 사람들의 부모 저장할 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//사람 수
		int M = sc.nextInt();//파티 수
		int k = sc.nextInt();//진실을 아는 사람 수

		//make-set
		p = new int[N+1];
		for(int i=0; i<N+1; i++) {
			p[i] = i;
		}
		
		//진실 아는 사람 체크
		boolean[] know = new boolean[N+1];
		for(int i=0; i<k;i++) {
			know[sc.nextInt()]=true;
		}
		
		//파티 정보 저장
		ArrayList<Integer>[] list = new ArrayList[M];//파티에 오는 사람 저장할 ArrayList
		for(int i=0; i<M; i++) list[i] = new ArrayList<>();//ArrayList 초기화
		PriorityQueue<Integer> pq;//union하기 위한 우선순위큐
		
		for(int i=0; i<M; i++) {
			pq = new PriorityQueue<>();
			int num = sc.nextInt();//i번째 파티에 오는 사람 수
			for(int j=0; j<num; j++) {
				int n = sc.nextInt();
				list[i].add(n);
				pq.add(n);
			}
			
			//union
			while(pq.size()>1) {
				int a = pq.poll();
				int b = pq.peek();
				union(a,b);
			}
		}
		
		//진실 알고 있는 사람과 부모가 같은 사람들의 know를 true로 바꿔줌
		boolean[] visited = new boolean[N+1];//방문체크 배열
		for(int i=1; i<N+1; i++) {
			if(know[i] && !visited[i]) {
				visited[i]=true;
				for(int j=1; j<N+1; j++) {
					if(findset(p[i])==findset(p[j]) && !visited[j]) {
						know[j]=true;
						visited[j]=true;
					}
				}
			}
		}
		
		int cnt = 0;//최대 거짓말 가능 횟수
		for(int i=0; i<M; i++) {
			boolean lie = true;//거짓말 가능 여부
			for(int j=1; j<N+1; j++) {
				//진실 아는 사람을 포함하고 있으면 pass를 true로 바꿔줌
				if(know[j] && list[i].contains(j)) {
					lie = false;
					break;
				}
			}
			if(lie) cnt++;
		}
		System.out.println(cnt);
		
	}

	private static int findset(int x) {
		if(x!=p[x]) p[x]=findset(p[x]);
		return p[x];
	}
	
	private static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}

}