import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//돌 개수
		
		//돌 1개 >> 상근 승
		//돌 2개 >> 상근 1개 창영 1개 창영 승
		//돌 3개 >> 상근 3개 상근 승
		//돌 4개 >> 상근 3개 창영 1개 / 상근 1개 창영 3개 창영 승
		//돌 개수 짝수일 때 창영이가 이기고 홀수면 상근이가 이김
		
		System.out.println((N%2==0)?"CY":"SK");
	}
}
