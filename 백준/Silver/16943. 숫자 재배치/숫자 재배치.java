import java.util.Scanner;

public class Main {
	
	static String A,B;
	static int len;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static int max = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		A = sc.next();
		B = sc.next();
		
		len = A.length();
		
		if(B.length()<len) {
			System.out.println(max);
			return;
		}
		
		visited = new boolean[len];
		
		select(0);
		
		System.out.println(max);
	}

	private static void select(int idx) {
		if(idx==len) {
			int C = Integer.parseInt(sb.toString());
			
			if(C<Integer.parseInt(B)) {
				max = Math.max(max, C);				
			}
			
			return;
		}
		
		
		for(int i=0; i<len; i++) {
			if(visited[i]) continue;
			
			if(idx==0 && A.charAt(i)=='0') continue; // 첫번째 자리에 0올 수 없음
			
			visited[i] = true;
			sb.append(A.charAt(i));
			
			select(idx+1);
			
			visited[i] = false;
			sb.deleteCharAt(sb.length()-1);
		}
	}

}