import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//문자 개수
		char[] c = sc.next().toCharArray();
		
		int sum = 0;
		//'a' 아스키코드 97!
		for(int i=0; i<N; i++) {
			sum += ((int)c[i]-96)*(int)Math.pow(31, i)%1234567891;	
		}
		System.out.println(sum);
	}
}
