import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next(); // 문자열
		String e = sc.next(); // 폭발 문자열

		Stack<Character> stack = new Stack<>();
		boolean equal; // 폭발 문자열 여부
		int idx; // 폭발 문자열 인덱스
		
		for(int i=0; i<s.length(); i++) {
			stack.push(s.charAt(i));
			
			if(stack.size()>=e.length()) {
				equal = true;
				idx = 0;
				
				// 스택에 폭발 문자열이 있는지 폭발 문자열의 글자수 만큼 검사
				for(int j=stack.size() - e.length(); j<stack.size(); j++) {
					if(stack.get(j) != e.charAt(idx++)) {
						equal = false;
						break;
					}
				}
				
				// 폭발 문자열있으면 스택에서 제거
				if(equal) {
					for(int j=0; j<e.length(); j++) stack.pop();
				}
			}
			
		}
		
		if(stack.size()>0) {
			StringBuilder sb = new StringBuilder();
			for(Character c : stack) {
				sb.append(c);
			}
			System.out.println(sb.toString());
		}else {
			System.out.println("FRULA");
		}
	}

}