import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int n = sc.nextInt();
		
		int[] x = new int[n];
		int[] y = new int[n];
		
		for(int i=0; i<n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		Arrays.sort(x);
		Arrays.sort(y);
		
		// 거리 합 최소로 하는 위치
		int midX = x[n/2];
		int midY = y[n/2];
		
		long sum = 0; // 최소 거리 합
		
		for(int i=0; i<n; i++) {
			sum += Math.abs(x[i]-midX) + Math.abs(y[i]-midY);
		}
		
		System.out.println(sum);
			
	}

}