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
		
		int num, s, e, mid;
		boolean exist;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			num = sc.nextInt();
			
			s = 0;
			e = N-1;
			exist = false;
			
			while(s<=e) {
				mid = (s+e)/2;
				
				if(cards[mid]<num) {
					s = mid + 1;
				}else if(cards[mid]>num) {
					e = mid - 1;
				}else {
					exist = true;
					break;
				}
			}
			
			if(exist) sb.append(1+" ");
			else sb.append(0+" ");
		}
		
		System.out.println(sb.toString());
	}

}