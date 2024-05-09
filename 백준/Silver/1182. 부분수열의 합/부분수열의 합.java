import java.util.Scanner;

public class Main {
	
	static int N, S;
	static int[] arr;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		recur(0,0);
		
		// S가 0인 경우 공집합인 경우 빼줘야해서 cnt-1 출력
		System.out.println(S==0? cnt-1 : cnt);
	}

	private static void recur(int idx, int sum) {
		if(idx==N) {
			if(sum==S) cnt++;
			
			return;
		}
		
		recur(idx+1, sum+arr[idx]);
		recur(idx+1, sum);
	}

	

}