import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[9];
		int sum = -100; // 찾아야할 가짜 난쟁이 두명의 키의 합
		for(int i=0; i<9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				if(arr[i]+arr[j]==sum) {
					print(arr, i, j);
					return;
				}
			}
		}
	}

	private static void print(int[] arr, int a, int b) {
		for(int i=0; i<9; i++) {
			if(i==a || i==b) continue;
			System.out.println(arr[i]);
		}
	}

}