import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int len = 0;//사이클의 길이
		
		int n = N;
		int tmp = 0;
		
		if(N>=10) n = N%10+N/10;
		n = N%10*10+n%10;
		len++;
		
		while(n != N) {
			if(n<10) {
				tmp=n;
			}else {
				tmp = n%10+n/10;
			}
			n = n%10*10 + tmp%10;
			len++;
		}
		System.out.println(len);
	}

}