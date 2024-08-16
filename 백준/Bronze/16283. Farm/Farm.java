import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); // 양이 먹는 사료 양
		int b = sc.nextInt(); // 염소가 먹는 사료 양
		int n = sc.nextInt(); // 양+염소 마리수
		int w = sc.nextInt(); // 양+염소가 먹은 사료 양
		
		int cnt = 0; // 정답 개수
		int sheep = 0; // 양 마리 수
		int goat = 0; // 염소 마리 수
		for(int i=1; i<n; i++) { // i = 양
			if(i*a + (n-i)*b == w) {
				cnt++;
				sheep = i;
				goat = n-i;
			}
		}
		
		if(cnt==1) {
			System.out.println(sheep+" "+goat);
		}else {
			System.out.println(-1);
		}
	}

}