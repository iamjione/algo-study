import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int ans = 0;//답 출력할 변수
		
        //N==1이면 답 1
        
		if(N!=1) {
			int num = 2;
			for(int i=1; num<=N; i++) {
				num = num+6*i;
				ans = i;
			}
		}
		System.out.println(ans+1);
	}
}