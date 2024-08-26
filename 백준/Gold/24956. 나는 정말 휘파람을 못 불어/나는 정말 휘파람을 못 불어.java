import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 문자열의 길이
		String s = sc.next(); // 문자열

		// 문자열 W,E 누적합 저장
		int[] w = new int[N + 1];
		int[] e = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			if (s.charAt(i - 1) == 'W') {
				w[i]++;
			} else if (s.charAt(i - 1) == 'E') {
				e[i]++;
			}

			w[i] += w[i - 1];
			e[i] += e[i - 1];
		}

		BigInteger cnt = BigInteger.valueOf(0); // 유사 휘파람 문자열 개수
		BigInteger combination; // e를 2개 이상 선택하는 경우의 수
		for (int i=2; i<=N-2; i++) {
			if (s.charAt(i-1) == 'H') {
				if (e[N]-e[i] >= 2) {
					combination = BigInteger.valueOf(2).pow(e[N]-e[i]).subtract(BigInteger.valueOf(e[N]-e[i] + 1));
					cnt = cnt.add(BigInteger.valueOf(w[i-1]).multiply(combination));
				}
			}
		}
		
		System.out.println(cnt.mod(BigInteger.valueOf(1000000007)));
	}
}