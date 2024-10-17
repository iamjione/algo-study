import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		
		int n = a.length();
		int m = b.length();
		
		int[][] LCS = new int[n+1][m+1];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a.charAt(i) == b.charAt(j)) {
					LCS[i+1][j+1] = LCS[i][j] + 1;
				}else {
					LCS[i+1][j+1] = Math.max(LCS[i][j+1], LCS[i+1][j]);
				}
			}
		}
		
		System.out.println(LCS[n][m]);
	}

}