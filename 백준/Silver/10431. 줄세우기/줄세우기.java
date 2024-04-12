import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();
		for(int tc=0; tc<P; tc++) {
			int T = sc.nextInt();
			int[] arr = new int[20];
			for(int i=0; i<20; i++) {
				arr[i] = sc.nextInt();
			}
			
			int cnt = 0; // 이동한 걸음수
			int tmp = 0; // 자리 앞으로 옮길 학생의 키
			for(int i=1; i<20; i++) {
				for(int j=0; j<i; j++) {
					// 앞에 더 큰 학생 있으면 걸음수 카운트
					if(arr[j]>arr[i]) {
						cnt++;
					}
				}
			}

			System.out.println(T+" "+cnt);
		}

	}

}