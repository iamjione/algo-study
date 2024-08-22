import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// Hoof, Paper, Scissors의 누적합 배열
		int[] h = new int[N+1];
		int[] p = new int[N+1];
		int[] s = new int[N+1];
		
		// H,P,S 입력받으면서 누적합 저장
		char c;
		for(int i=1; i<=N; i++) {
			c = sc.next().charAt(0);
			
			if(c=='H') {
				h[i] = 1;
			}else if(c=='P') {
				p[i] = 1;
			}else {
				s[i] = 1;
			}
			
			h[i] += h[i-1];
			p[i] += p[i-1];
			s[i] += s[i-1];
		}
		
		// i번째에서 누적합 최대인 것 찾고 누적합 최대인 것 제외한 두개 중 i+1번째부터 N번째까지의 누적합 최대인 것 찾아서 두 누적합 더하기
		int max = 0;
		for(int i=1; i<=N; i++) {
			if(h[i] >= p[i] && h[i] >= s[i]) {
				max = Math.max(max, h[i] + Math.max(p[N]-p[i], s[N]-s[i]));
			}
			
			if(p[i] >= h[i] && p[i] >= s[i]) {
				max = Math.max(max, p[i] + Math.max(h[N]-h[i], s[N]-s[i]));
			}
			
			if(s[i] >= h[i] && s[i] >= p[i]) {
				max = Math.max(max, s[i] + Math.max(h[N]-h[i], p[N]-p[i]));
			}
		}
		
		System.out.println(max);
	}

}