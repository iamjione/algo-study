import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int answer = 0;
		for(int i=1; i<=1000; i++) { //B
			for(int j=i+1; j<=1000; j++) { //A
				if(i*i+N==j*j) answer++;
			}
		}
		
		System.out.println(answer);
	}

}