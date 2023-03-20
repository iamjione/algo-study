import java.util.Scanner;

public class 이진수표현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			String ans = "ON";//답으로 출력할 문자
			for(int i=0; i<N; i++) {
				//M을 2로 나눈 나머지가 0이면 답을 OFF로 바꿔주고 break
				if(M%2==0) {
					ans = "OFF";
					break;
				}
				//M을 2로 나눈 나머지가 1이면 right shift
				else M=M>>1;
			}
			System.out.println("#"+tc+" "+ans);			
		}
	}
}
