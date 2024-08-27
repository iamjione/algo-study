import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int s = 0;
		int e = 0;
		int sum = arr[0];
		int cnt = 0;
		while(e<N) {
			if(sum>M) {
				sum -= arr[s];
				s++;
			}else if(sum<M) {
				e++;
				if(e>=N) break;
				sum += arr[e];
			}else {
				cnt++;
				sum -= arr[s];
				s++;
				e++;
				if(e>=N) break;
				sum += arr[e];
			}
		}
		
		System.out.println(cnt);
	}

}