import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int N = sc.nextInt();
		
		for(int i=1; i<=300/A; i++) {
			for(int j=1; j<=300/B; j++) {
				for(int k=1; k<=300/C; k++) {
					if(A*i + B*j + C*k == N) {
						System.out.println(1);
						return;
					}
				}
			}
		}
		
		System.out.println(0);
	}

}