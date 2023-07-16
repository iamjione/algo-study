import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//테스트케이스 수
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();//전화번호의 수
			String[] arr = new String[N];
			for(int i=0; i<N; i++) arr[i] = sc.next();
			
			Arrays.sort(arr);
			
			boolean consistent = true;
			for(int i=0; i<N-1; i++) {
				if(arr[i+1].startsWith(arr[i])) {
					consistent = false;
					break;
				}
			}
			
			if(consistent) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}