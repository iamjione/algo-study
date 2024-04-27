import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int N = sc.nextInt();
		
		for(int i=N/C; i>=0; i--) {
			for(int j=N/B; j>=0; j--) {
				for(int k=N/A; k>=0; k--) {
					if(C*i + B*j + A*k == N) {
						System.out.println(1);						
						return;
					}
				}
			}
		}
		
		System.out.println(0);
	}

}