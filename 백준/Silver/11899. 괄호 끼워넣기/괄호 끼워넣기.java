import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<s.length(); i++){
			if(!stack.isEmpty() && stack.peek()=='(' && s.charAt(i)==')') {
				stack.pop();
			}else {
				stack.push(s.charAt(i));
			}
		}
		
		System.out.println(stack.size());
	}

}