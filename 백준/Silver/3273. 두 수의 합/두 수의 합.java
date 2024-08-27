import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int x = sc.nextInt();
		
		Arrays.sort(arr);
		
		int cnt = 0; // 조건 만족하는 쌍의 수
		int s = 0;
		int e = n-1;
		
		while(s<e) {
			if(arr[s]+arr[e] > x) {
				e--;
			}else if(arr[s]+arr[e] < x) {
				s++;
			}else {
				cnt++;
				s++;
				e--;
			}
		}
		
		System.out.println(cnt);
	}

}