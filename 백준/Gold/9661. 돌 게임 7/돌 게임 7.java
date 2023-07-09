import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		
		if(N%5 == 0 || N%5 == 2) System.out.println("CY");
		else System.out.println("SK");

	}

}