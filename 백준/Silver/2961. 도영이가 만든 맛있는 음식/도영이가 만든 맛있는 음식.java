import java.util.Scanner;

public class Main {

	static int N;
	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N][2];
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		recur(0, 1, 0, 0);
		
		System.out.println(min);
	}

	private static void recur(int idx, int a, int b, int cnt) {
		if(idx==N) {
			if(cnt>0) {
				min = Math.min(min, Math.abs(b-a));
			}
			return;
		}
		
		recur(idx+1, a*arr[idx][0], b+arr[idx][1], cnt+1);
		recur(idx+1, a, b, cnt);
	}

}