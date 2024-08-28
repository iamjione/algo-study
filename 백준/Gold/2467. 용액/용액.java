import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int s = 0;
		int e = N-1;
		long min = Long.MAX_VALUE;
		long sum;
		int[] ans = new int[2];
		while(s<e) {
			sum = arr[s] + arr[e];
			if(Math.abs(sum)<min) {
				min = Math.abs(sum);
				ans[0] = arr[s];
				ans[1] = arr[e];
			}
			
			if(sum > 0) {
				e--;
			}else if(sum < 0) {
				s++;
			}else {
				break;
			}
		}
		
		System.out.println(ans[0]+" "+ans[1]);
	}

}