package baekjoon;

import java.util.Scanner;

public class Main15829 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//문자 개수
		char[] c = sc.next().toCharArray();
		/*
		31의 49제곱은
		11932267966476130911517907186867185074148138371734008968629799047943267871
		인데 Math.pow(31,49)하면 1.1932267966476131E73 출력함
		Math.pow() 사용하면 100점 맞기 불가능!
		 */
		long sum = 0;
		long square = 1;
		//'a' 아스키코드 97!
		for(int i=0; i<N; i++) {
			sum += ((int)c[i]-96)*square%1234567891;
			square = square*31%1234567891;
		}
		System.out.println(sum%1234567891);
	}
}
