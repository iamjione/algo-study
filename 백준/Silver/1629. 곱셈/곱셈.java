import java.util.Scanner;

public class Main {

	static int C;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		C = sc.nextInt();

		long ans = calculate(A,B);
		System.out.println(ans);
	}

	private static long calculate(int a, int b) {
		//기저조건
		if(b==1) return a%C;
				
		//재귀 조건
		//1. 짝수일 때
		if(b%2==0) {
			long ans = calculate(a,b/2);
			return (ans*ans)%C;
		//2. 홀수일 때
		}else {
			long ans = calculate(a,(b-1)/2);
			return ((ans*ans)%C*a)%C;
		}
	}
}