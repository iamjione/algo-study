import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int s = 1;
		int e = K;
		int l = 0;
		int mid, cnt;
		
		while(s<=e) {
			mid = (s+e)/2;
			cnt = 0; // mid보다 작거나 같은 숫자의 개수
			
			for(int i=1; i<=Math.min(N, mid); i++) {
				cnt += Math.min(mid/i, N);
			}
			
			if(cnt >= K) {
				l = mid;
				e = mid-1;
			}else {
				s = mid+1;
			}
		}
		
		System.out.println(l);
	}

}