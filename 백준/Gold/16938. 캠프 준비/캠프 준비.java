import java.util.Scanner;

public class Main {

	static int N, L, R, X;
	static int[] arr;
	static int answer = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		X = sc.nextInt();
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=2; i<=N; i++) {
			select(i, 0, 0, 0, 1000001, 0);
		}
		
		System.out.println(answer);
	}

	private static void select(int total, int curr, int start, int max, int min, int sum) {
		if(sum>R) return;
		
		if(total==curr) {
			if(L<=sum && sum<=R && max-min>=X) answer++;
			return;
		}
		
		for(int i=start; i<N; i++) {			
			select(total, curr+1, i+1, Math.max(max, arr[i]), Math.min(min, arr[i]), sum+arr[i]);
		}
		
	}

}