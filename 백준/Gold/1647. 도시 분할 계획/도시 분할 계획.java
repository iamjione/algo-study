import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//집의 개수
		int M = Integer.parseInt(st.nextToken());//길의 개수
		
		//간선 정보
		//1: 시작 정점, 2: 끝 정점, 3: 유지비
		int[][] edges = new int[M][3];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
		
		//크루스칼 1단계 : 간선 오름차순 정렬
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		
		//크루스칼 2단계 : 사이클이 생기지 않게 N-1개의 간선 뽑기
		p = new int[N+1];
		//1) make-set (나 자신을 대표로 초기화)
		for(int i=1; i<N+1; i++) {
			p[i]=i;
		}
		
		int cost = 0;//최소비용
		int cnt = 0;//뽑은 간선의 수
		int max = 0;//연결 된 간선 중 최대 비용
		
		int idx = 0;
		while(cnt<(N-1)) {
			//i번째의 간선을 뽑아서 두 정점의 대표 확인
			int px = findset(edges[idx][0]);//edges[i][0]의 부모
			int py = findset(edges[idx][1]);//edges[i][1]의 부모
			
			//부모가 다르면 union
			if(px!=py) {
				if(py>px) p[px] = findset(py);
				else p[py] = findset(px);
				
				cost += edges[idx][2];//비용 더해주기
				if(max<edges[idx][2]) max = edges[idx][2];//비용 최대값 갱신
				cnt++;
			}
			idx++;
		}
		System.out.println(cost-max);
	}

	private static int findset(int x) {
		if(x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}

}