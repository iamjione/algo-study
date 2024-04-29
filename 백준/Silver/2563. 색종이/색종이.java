import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//색종이 개수
		int[][] arr = new int[100][100];//도화지

		int cnt = 0;//겹치는 부분
		
		for(int i=0; i<n; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			for(int j=0; j<10; j++) {
				for(int k=1; k<11; k++) {
					arr[r+j][90-c+k]+=1;
					if(arr[r+j][90-c+k]>1) cnt++;
				}
			}
		}
		System.out.println(100*n-cnt);
	}

}