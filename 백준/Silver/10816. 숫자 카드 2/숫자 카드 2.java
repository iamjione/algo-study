import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] cards = new int[N];
		for(int i=0; i<N; i++) {
			cards[i] = sc.nextInt();
		}
		
		Arrays.sort(cards);
		
		int M = sc.nextInt();
		
		int num, s, e, l, u, mid;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			num = sc.nextInt();
			
			// lower bound 구하기
			// num보다 크거나 같은 숫자의 가장 왼쪽 인덱스
			s = 0;
			e = N-1;
			l = -1;
			
			while(s<=e) {
				mid = (s+e)/2;
				
				if(cards[mid]>=num) {
					l = mid;
					e = mid - 1;
				}else {
					s = mid + 1;
				}
			}
			if(l==-1) l = N;
			
			//upper bound 구하기
			// num보다 큰 숫자의 가장 왼쪽 인덱스
			s = 0;
			e = N-1;
			u = -1;
			
			while(s<=e) {
				mid = (s+e)/2;
				
				if(cards[mid]>num) {
					u = mid;
					e = mid - 1;
				}else {
					s = mid + 1;
				}
			}
			if(u==-1) u = N;
			
			sb.append(u-l+" ");
		}
		
		System.out.println(sb.toString());
	}

}