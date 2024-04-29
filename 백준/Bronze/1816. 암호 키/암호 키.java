import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long key;
		for(int i=0; i<N; i++) {
			key = sc.nextLong();
			
			if(isValid(key)) System.out.println("YES");
			else System.out.println("NO");
		}
	}

	private static boolean isValid(long key) {
		for(int i=2; i<=1000000; i++) {
			if(key%i==0) {
				return false;
			}
		}
		return true;
	}

}