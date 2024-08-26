import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int W = sc.nextInt();
		
		int[] arr = new int[W+1];
		int[] prefix_max = new int[W+1];
		int[] sufix_max = new int[W+2];
		
		for(int i=1; i<=W; i++) {
			arr[i] = sc.nextInt();
			prefix_max[i] = Math.max(prefix_max[i-1], arr[i]);
		}
		
		for(int i=W; i>=1; i--) {
			sufix_max[i] = Math.max(sufix_max[i+1], arr[i]);
		}
		
		// 각 칸에 고이는 빗물 양 = 왼쪽 최대값과 오른쪽 최대값 중 최소값 - 내 자신의 값
		int sum = 0;
		for(int i=1; i<=W; i++) {
			sum += Math.min(prefix_max[i], sufix_max[i])-arr[i];
		}

		System.out.println(sum);
	}

}