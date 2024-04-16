import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[][] dr1 = {{0,0,0,0},{0,1,2,3}};
		int[][] dc1 = {{0,1,2,3},{0,0,0,0}};
		
		int[][] dr2 = {{0,0,1,1},{0,1,1,2}};
		int[][] dc2 = {{0,1,1,2},{1,1,0,0}};
		
		int[][] dr3 = {{0,0,0,1},{0,1,2,2},{0,1,1,1},{0,0,1,2}};
		int[][] dc3 = {{0,1,2,2},{1,1,1,0},{0,0,1,2},{0,1,0,0}};
		
		int[][] dr4 = {{0,0,0,1},{1,1,1,0},{0,1,1,2},{0,1,1,2}};
		int[][] dc4 = {{0,1,2,1},{0,1,2,1},{0,0,1,0},{1,0,1,1}};
		
		int[] dr5 = {0,0,1,1};
		int[] dc5 = {0,1,0,1};
		
		Scanner sc = new Scanner(System.in);
		int TC = 0;
		while(true) {
			TC++;
			
			int N = sc.nextInt();
			if(N==0) break;
			
			int[][] arr = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int max = Integer.MIN_VALUE;
			int sum1, sum2, sum3, sum4, sum5;
			boolean flag;
			for(int i=0; i<N-1; i++) {
				for(int j=0; j<N-1; j++) {
					
					for(int k=0; k<2; k++) {
						// 첫번째 도형
						sum1 = 0;
						flag = true;
						for(int d=0; d<4; d++) {
							if(i+dr1[k][d]>=N || j+dc1[k][d]>=N) {
								flag = false;
								break;
							}
							sum1+= arr[i+dr1[k][d]][j+dc1[k][d]];
						}
						if(flag) max = Math.max(max, sum1);
						
						// 두번째 도형
						sum2 = 0;
						flag = true;
						for(int d=0; d<4; d++) {
							if(i+dr2[k][d]>=N || j+dc2[k][d]>=N) {
								flag  = false;
								break;
							}
							sum2 += arr[i+dr2[k][d]][j+dc2[k][d]];
						}
						if(flag) max = Math.max(max, sum2);
					}
					
					for(int k=0; k<4; k++) {
						// 3번째 도형
						sum3 = 0;
						flag = true;
						for(int d=0; d<4; d++) {
							if(i+dr3[k][d]>=N || j+dc3[k][d]>=N) {
								flag = false;
								break;
							}
							sum3 += arr[i+dr3[k][d]][j+dc3[k][d]];
						}
						if(flag) max = Math.max(max, sum3);
						
						// 4번째 도형
						sum4 = 0;
						flag = true;
						for(int d=0; d<4; d++) {
							if(i+dr4[k][d]>=N || j+dc4[k][d]>=N) {
								flag = false;
								break;
							}
							sum4 += arr[i+dr4[k][d]][j+dc4[k][d]];
						}
						if(flag) max = Math.max(max, sum4);
					}
					
					// 5번째 도형
					sum5 = 0;
					for(int d=0; d<4; d++) {
						sum5 += arr[i+dr5[d]][j+dc5[d]];
					}
					max = Math.max(max, sum5);
				}
			}
			
			System.out.println(TC+". "+max);
		}
		
	}
}