import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());//집합 n+1개
		int m = Integer.parseInt(st.nextToken());//연산 횟수
		
		p = new int[n+2];
		
		//make-set
		for(int i=0; i<n+1; i++) {
			p[i] = i;
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(cmd==0) {
				union(x,y);
			}else {//cmd==1
				if(findset(x)==findset(y)) sb.append("YES").append('\n');
				else sb.append("NO").append('\n');
			}
		}
		System.out.println(sb);
	}

	private static int findset(int x) {
		if(x != p[x]) p[x] = findset(p[x]);
		return p[x];
	}

	private static void union(int x, int y) {
		p[findset(y)]=findset(x);
	}

}