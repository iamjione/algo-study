import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();//욱제가 가장 좋아하는 문자열
		int K = sc.nextInt();//등장 횟수
		
		long commonLength = getPi(s);
		System.out.println(s.length()+(s.length()-commonLength)*(K-1));
	}

	private static long getPi(String s) {
		//접두사와 접미사가 일치하는 최대 길이를 담을 배열
		int[] pi = new int[s.length()];//0~i까지의 부분 문자열에서 접미사&접두사 일치하는 길이를 담음
		
		int j = 0;
		for(int i=1; i<s.length(); i++) {
			//i와 j가 가르키는 값이 다르면
			while(j>0 && s.charAt(i)!=s.charAt(j)) {
				j = pi[j-1];
			}
			//i와 j가 가르키는 값이 같으면
			//i번째의 최대 길이는 ++j한 값
			if(s.charAt(i)==s.charAt(j)) pi[i] = ++j;
		}
		//접두사와 접미사 일치하는 최대 길이 반환
		return pi[s.length()-1];
	}

}