import java.util.Scanner;
import java.util.Stack;

public class Main {

	static String s, e;
	static Stack<Character> stack = new Stack();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.next();
		e = sc.next();
		
		for(int i=0; i<s.length(); i++) {
			stack.push(s.charAt(i));
			
			// 스택에 들어있는 문자 수가 폭발 문자열보다 크거나 같고 폭발 문자열이 있으면 폭발!
			if(stack.size() >= e.length() && findE()) explode();
		}

		// 출력
		if(stack.isEmpty()) {
			System.out.println("FRULA");
		}
		else {
			StringBuilder sb = new StringBuilder();
			
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			
			System.out.println(sb.reverse());
		}
		
	}
	
	// 폭발 문자열 찾기
	private static boolean findE() {
		int idx = e.length()-1;
		
		// 스택 위에서 부터 폭발 문자열 글자수 만큼 확인하기
		for(int i=stack.size()-1; i >= stack.size()-e.length(); i--) {
			if(stack.get(i) == e.charAt(idx)) idx--;
			else return false;
		}
		
		return true;
	}
	
	// 문자열 폭발
	private static void explode() {
		for(int i=0; i<e.length(); i++) stack.pop();
	}

}