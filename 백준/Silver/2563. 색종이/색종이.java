import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] arr = new int[101][101];
		
		int r,c;
		int cnt = 0;
		for(int i=0; i<N; i++) {
			r = sc.nextInt();
			c = sc.nextInt();
			
			for(int j=r; j<=r+9; j++) {
				for(int k=c; k<=c+9; k++) {
					arr[j][k]++;
					
					if(arr[j][k]==1) cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}