import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		String[] arr = new String[N];// 괄호 입력받을 배열
		for (int i = 0; i < N; i++)
			arr[i] = sc.next(); // 배열 입력받기
		

		for (int i = 0; i < N; i++)
			System.out.println(isVPS(N, arr[i]));//출력
	}

	private static String isVPS(int N, String s) {
		Stack<Character> st = new Stack<>();// 괄호 담을 스택
		
		for (int j = 0; j < s.length(); j++) {
			char c = s.charAt(j);//문자열의 괄호 하나씩 나눠줌
			if (c == '(')
				st.add(c);//(면 스택에 추가
			else {
				if (st.isEmpty()) {
					return "NO";//)인데 스택 비어있으면 NO리턴
				} else {
					st.pop();//아니면 가장 마지막값인 ( 제거
				}
			}
		}
		if (st.isEmpty())
			return "YES";
		else
			return "NO";
	}
}