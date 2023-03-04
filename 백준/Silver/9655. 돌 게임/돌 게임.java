import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//돌 개수
		System.out.println((N%2==0)?"CY":"SK");
	}
}