import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//nCm 구하는 문제
        int n = sc.nextInt();
		int m = sc.nextInt();
		//n과 m의 최대값이 100이므로 BigInteger 사용해야함
		BigInteger ans = new BigInteger("1");
		
		//(n-m)!
		for(int i=n; i>n-m; i--) {
			ans = ans.multiply(new BigInteger(i+""));
		}
		//m!으로 나눠주기
		for(int i=1; i<=m; i++) {
			ans = ans.divide(new BigInteger(i+""));
		}	
		System.out.println(ans);
	}
}