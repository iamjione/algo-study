import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	static int N;
	static int[] arr;
	static int max = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arr = new int[N];
		Set<Integer> set = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			set.add(arr[i]);
		}
		
		// 숫자 하나씩 제거하면서 가장 긴 연속된 수의 개수 찾기
		for(int n : set) {
			cntMax(n);
		}
		
		System.out.println(max);
	}

	private static void cntMax(int n) {
		int l = 0;
		int r = 0;
		
		while(arr[l]==n) {
			l++;
			r++;
		}
		
		int cnt = 0;
		while(r<N) {
			if(arr[l]==arr[r]) {
				cnt++;
				r++;
				
				while(r<N && arr[r]==n) r++;
			}else {
				max = Math.max(max, cnt);
				cnt = 0;
				l=r;
			}
		}
		max = Math.max(max, cnt);
	}

}