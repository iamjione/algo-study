import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 주요 고객 수
		
		int[] arrX = new int[n]; // 고객들의 x좌표
		int[] arrY = new int[n]; // 고객들의 y좌표
		
		for(int i=0; i<n; i++) {
			arrX[i] = sc.nextInt();
			arrY[i] = sc.nextInt();
		}
		
		Arrays.sort(arrX);
		Arrays.sort(arrY);
		
		int x = arrX[n/2]; // 편의점의 x좌표
		int y = arrY[n/2]; // 편의점의 y좌표
		
		long sum = 0; // 모든 고객과 편의점의 최소 거리 합
		for(int i=0; i<n; i++) {
			sum += Math.abs(arrX[i]-x)+Math.abs(arrY[i]-y);
		}
		
		System.out.println(sum);
		
	}

}