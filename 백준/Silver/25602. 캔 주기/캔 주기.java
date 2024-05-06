import java.util.Scanner;

public class Main {

	static int N, K;
	static int[] A;
	static int[][] R, M;
	static int max = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		A = new int[N];
		R = new int[K][N];
		M = new int[K][N];
		
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		for(int i=0; i<K; i++) {
			for(int j=0; j<N; j++) {
				R[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<K; i++) {
			for(int j=0; j<N; j++) {
				M[i][j] = sc.nextInt();
			}
		}
		
		giveCan(0, 0);
		
		System.out.println(max);
	}

	private static void giveCan(int day, int sum) {
		if(day == K) {
			max = Math.max(max, sum);
			return;
		}
		
		 for(int i=0; i<N; i++) {
			 if(A[i]==0) continue;
			 
			 sum += M[day][i];
			 A[i]--;
			 
			 for(int j=0; j<N; j++) {
				 if(A[j]==0) continue;
				 
				 sum += R[day][j];
				 A[j]--;
				 
				 giveCan(day+1, sum);
				 
				 sum -= R[day][j];
				 A[j]++;
			 }
			 sum -= M[day][i];
			 A[i]++;
		 }
		
	}

}