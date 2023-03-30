package 그래프최소비용;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 하나로 {

	static double E;
	static int[] p;
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int N =sc.nextInt();//섬의 개수
			
			arr = new int[N][2];//섬 좌표 저장할 배열
			
			for(int i=0; i<N; i++) {
				arr[i][0] = sc.nextInt();//i섬의 x좌표
			}
			
			for(int i=0; i<N; i++) {
				arr[i][1] = sc.nextInt();//i섬의 y좌표				
			}
			
			E = sc.nextDouble();//환경 부담 세율
			
			int size = N*(N-1)/2;//간선의 개수
			double[][] edges = new double[size][3];
			
			int idx=0;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					edges[idx][0] = i;
					edges[idx][1] = j;
					edges[idx][2] = cost(i,j);
					idx++;
				}
			}
		
			//크루스칼 1단계 : 간선 오름차순 정렬
			Arrays.sort(edges, new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					return Double.compare(o1[2], o2[2]);
				}
			});
			
			//크루스칼 2단계 : 사이클이 생기지 않게 N-1개의 간선 뽑기
			p = new int[N];
			//1) make-set (나 자신을 대표로 초기화)
			for(int i=0; i<N; i++) {
				p[i] = i;
			}
			
			double ans = 0;//최소비용
			int cnt = 0;//선택한 간선의 수
			
			int i = 0;
			while(cnt<(N-1)) {
				//i번째의 간선을 뽑아서 두 정점의 대표 확인
				int x = (int) edges[i][0];
				int y = (int) edges[i][1];
				
				if(findset(x) != findset(y)) {//사이클이 아니면
					union(x,y);
					ans += edges[i][2];
					cnt++;
				}
                i++;
            }
             
            System.out.println("#"+tc+" "+Math.round(ans));

		}//tc

	}

	private static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}

	private static int findset(int x) {
		 //path-compression
        if(x != p[x])
            p[x] = findset(p[x]);
        return p[x];
	}

	//i섬과 j섬의 연결 비용
	private static double cost(int i, int j) {	
		return (Math.pow(arr[i][0]-arr[j][0],2)+Math.pow(arr[i][1]-arr[j][1],2))*E;
	}

}
