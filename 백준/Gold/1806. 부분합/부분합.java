import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int S = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int s = 0;
		int e = 0;
		int sum = arr[0];
		int length = Integer.MAX_VALUE;
		while(true) {
			if(sum < S) {
				e++;
				if(e>=N) break;
				sum += arr[e];
			}else {
				length = Math.min(length, e-s+1);

				sum -= arr[s];
				s++;
			}
		}
		
		System.out.println(length==Integer.MAX_VALUE?0:length);
	}

}