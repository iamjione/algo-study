import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+2];
		
		if(N==1) {
			System.out.println(1%10007);
		}else {
			arr[1] = 1;
			arr[2] = 2;
			
			for(int i = 3;i<N+1;i++) {
				arr[i]=(arr[i-1]+arr[i-2])%10007;
			}
			System.out.println(arr[N]);
		}

	}
}