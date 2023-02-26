import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		arr[1] = 1;
		for(int i=2; i<=N; i++) {
			if(i%2==0) arr[i]=(arr[i-1]*2+1)%10007;
			else arr[i]=(arr[i-1]*2-1)%10007;
		}
		System.out.println(arr[N]%10007);
	}
}