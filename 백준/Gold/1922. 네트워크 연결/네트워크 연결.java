import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();//정점의 개수
		int E = sc.nextInt();//간선의 개수
		
		//간선 정보 입력받아서 배열에 저장
		int[][] edges = new int[E][3];
		for(int i=0; i<E; i++) {
			edges[i][0] = sc.nextInt();//시작 정점
			edges[i][1] = sc.nextInt();//끝 정점
			edges[i][2] = sc.nextInt();//가중치
		}
		
		//step1. edges 배열을 가중치 기준으로 오름차순 정렬
		Arrays.sort(edges, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		
		//step2. 사이클 생기지 않게 V-1개 간선 뽑기 
		p = new int[V+1];//부모 정보 입력할 배열

		//makeset
		for(int i=1; i<V+1; i++) {
			p[i] = i;
		}
		
		int ans = 0;//최소 비용
		int cnt = 0;//선택한 간선의 수
		
		int i = 0;
		while(cnt<(V-1)) {
			int px = findset(edges[i][0]);//edges[i][0]의 부모
			int py = findset(edges[i][1]);//edges[i][1]의 부모
			
			//부모가 다르면 union
			if(px!=py) {
				union(px, py);
				ans += edges[i][2];
				cnt++;
			}
			i++;
		}
		
		System.out.println(ans);
	}

	private static void union(int px, int py) {
		if(py>px) p[px] = findset(py);
		else p[py] = findset(px);
	}

	private static int findset(int x) {
		//path-compression
		if(x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}

}