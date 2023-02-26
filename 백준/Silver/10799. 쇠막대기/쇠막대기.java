import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.next().toCharArray();//괄호 입력받기
		
		Stack<Character> stack = new Stack<>();
		
		int cnt = 0;//쇠막대기 조각 개수
		
		for(int i=0; i<c.length; i++) {
			switch(c[i]) {
			case'(':
				stack.push(c[i]);
				break;
			case')':
				if(c[i-1]=='(') {//레이저
					stack.pop();
					cnt += stack.size();
				}else {//쇠막대기 끝부분
					stack.pop();
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}