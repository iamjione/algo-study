package 그래프최소비용;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 창용마을무리의개수 {

	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();//사람 수
			int M = sc.nextInt();//서로 알고 있는 사람의 관계 수
			
			p = new int[N+1];//부모 정보 입력할 배열
			
			//makeset
			for(int i=1; i<N+1; i++) {
				p[i] = i;
			}
			
			//서로 알고 있는 두 사람 입력받아서 union
			for(int i=0; i<M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				union(x,y);
			}

			int cnt=1;
			for(int i=1; i<N; i++) {
				for(int j=i+1; j<N+1; j++) {
					if(findset(i)!=findset(j)) {
						union(i,j);
						cnt++;
					}
				}
			}
			
			System.out.println("#"+tc+" "+cnt);//set의 사이즈==무리의 수
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

}
