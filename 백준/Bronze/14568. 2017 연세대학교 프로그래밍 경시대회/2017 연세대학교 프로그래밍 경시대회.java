import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 사탕 개수
		
		int cnt = 0;
		int a = 2;
		int b,c;
		
		while(a<=N-4) {
			b = 1;
			c = N-a-b;
			while(c-b>=2) {
				b++;
				c--;
				cnt++;
			}
			a+=2;
		}
		System.out.println(cnt);
	}

}