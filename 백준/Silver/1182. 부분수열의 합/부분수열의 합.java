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
		
		for(int i=1; i<=N; i++) {
			count(i, 0, 0, 0);			
		}
		
		System.out.println(cnt);
	}

	// total : 총 선택할 숫자 개수
	// curr : 현재까지 선택한 숫자 개수
    // start : 탐색 시작할 인덱스
	// sum : 현재까지 선택한 숫자들의 합
	private static void count(int total, int curr, int start, int sum) {
		if(total==curr) {
			if(sum==S) cnt++;
			return;
		}
		
		for(int i=start; i<N; i++) {
			count(total, curr+1, i+1, sum+arr[i]);
		}
	}

}