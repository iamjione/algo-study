import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean[] arr = new boolean[N-M+1];
		
		if(M==1) arr[0]=true;
		
		for(int i=2;i<=Math.sqrt(N);i++) {
			for(int j=M;j<N+1;j++) {
				if(j%i==0 && j!=i) {
					arr[j-M]=true;
				}
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==false) {
				System.out.println(i+M);
			}
		}

	}

}