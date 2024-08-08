import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		for(int i=-2000; i<=2000; i++) {
			if(i*i+2*A*i+B==0) System.out.print(i+" ");
		}
	}

}