import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int h1, h2, s, e;
		int min = Integer.MAX_VALUE;
		// 첫번째 눈사람 만들 눈덩이 고르기
		for(int i=0; i<N-1; i++) {
			for(int j=i+3; j<N; j++) {
				h1 = arr[i]+arr[j]; // 첫번째 눈사람 키
				
				// 두번째 눈사람 만들 눈덩이 고르기
				s = i+1;
				e = j-1;
				while(s<e) {
					h2 = arr[s]+arr[e]; // 두번째 눈사람 키
					
					// 두 눈사람 크기 차이의 최소값 갱신
					min = Math.min(min, Math.abs(h1-h2));
					
					if(h1 < h2) {
						e--;
					}else if(h1 > h2) {
						s++;
					}else {
						break;
					}
				}
			}
		}
		
		System.out.println(min);
	}

}