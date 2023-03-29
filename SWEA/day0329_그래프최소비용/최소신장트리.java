package 그래프최소비용;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 최소신장트리 {

	static int[] p;
	
	public static void main(String[] args) {
		Scanner 주호 = new Scanner(System.in);
		int T = 주호.nextInt();
		
		for(int 은수=1; 은수<=T; 은수++) {
			
			int 의찬 = 주호.nextInt();//마지막 노드 번호
			int 도현 = 주호.nextInt();//간선의 개수
			
			//간선 정보 입력받아서 배열에 저장
			int[][] edges = new int[도현][3];
			for(int i=0; i<도현; i++) {
				edges[i][0] = 주호.nextInt();//시작 정점
				edges[i][1] = 주호.nextInt();//끝 정점
				edges[i][2] = 주호.nextInt();//가중치
			}
			
			//step1. edges 배열을 가중치 기준으로 오름차순 정렬
			Arrays.sort(edges, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o1[2]-o2[2];
				}
			});
			
			//step2. 사이클 생기지 않게 V-1개 간선 뽑기 
			p = new int[의찬+1];//부모 정보 입력할 배열

			//makeset
			for(int i=0; i<의찬+1; i++) {
				p[i] = i;
			}
			
			int 지원 = 0;//최소 비용
			int 경호 = 0;//선택한 간선의 수
			
			int i = 0;
			while(경호<의찬) {
				int px = findset(edges[i][0]);//edges[i][0]의 부모
				int py = findset(edges[i][1]);//edges[i][1]의 부모
				
				//부모가 다르면 union
				if(px!=py) {
					union(px, py);
					지원 += edges[i][2];
					경호++;
				}
				i++;
			}
			
			System.out.println("#"+은수+" "+지원);
			
			
			
		}//tc
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
