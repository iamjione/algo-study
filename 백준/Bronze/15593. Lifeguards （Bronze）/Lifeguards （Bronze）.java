import java.util.Scanner;

public class Main {

	static int N;
	static int[][] arr;
	static boolean[] work;
	static int max = 0;
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N][2];
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			fire(i);
		}
		
		System.out.println(max);
	}

	// n번째 소를 해고했을 때 몇시간 커버하는지 계산하는 메서드
	private static void fire(int n) {
		work = new boolean[1001];
		
		for(int i=0; i<N; i++) {
			if(i==n) continue;
			
			for(int j=arr[i][0]; j<arr[i][1]; j++) {
				work[j] = true;
			}
		}
		
		int cnt = 0;
		for(int j=0; j<1001; j++) {
			if(work[j]) cnt++;
		}
		
		max = Math.max(max, cnt);
	}

}