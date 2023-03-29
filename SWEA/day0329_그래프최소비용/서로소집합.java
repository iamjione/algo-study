package 그래프최소비용;

import java.util.Scanner;

public class 서로소집합 {

	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int n = sc.nextInt();//원소 개수
			//make-set
			p = new int[n+1];
			for(int i=1; i<n+1; i++) {
				p[i] = i;
			}
			
			int m = sc.nextInt();//연산의 개수
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<m; i++) {
				int cmd = sc.nextInt();//연산 종류
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				switch(cmd) {
				case 0://a가 포함된 집합과 b가 포함된 집합 합침
					union(a,b);
					break;
				case 1://a와 b가 같은 집합에 포함되어있는지 확인
					//같은 집합에 속해있으면 1, 아니면 0을 출력
					if(findset(a)!=findset(b)) sb.append(0);
					else sb.append(1);
					break;
				}
			}
			
			System.out.println("#"+tc+" "+sb);
		}
	}

	static int findset(int x) {
		//path-compression
		if( x != p[x]) p[x] = findset(p[x]);
		return p[x];
		
	}
	
	static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}

}
