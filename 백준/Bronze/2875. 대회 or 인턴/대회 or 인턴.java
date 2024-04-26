import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 여학생 수
		int M = sc.nextInt(); // 남학생 수
		int K = sc.nextInt(); // 인턴쉽 참여 인원
		
		int answer = 0;
		for(int i=0; i<=K; i++) { //i: 인턴쉽 참가하는 여학생 수
			answer = Math.max(Math.min((N-i)/2, M-(K-i)), answer);
		}
		
		System.out.println(answer);
	}

}