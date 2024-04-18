import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int ans1 = -A-(int)Math.sqrt(A*A-B);
		int ans2 = -A+(int)Math.sqrt(A*A-B);
		
		if(ans1==ans2) System.out.println(ans1);
		else System.out.println(ans1+" "+ans2);		
	}

}