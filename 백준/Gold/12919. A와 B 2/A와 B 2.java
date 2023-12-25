import java.util.Scanner;

public class Main {
	
	static boolean possible = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		String t = sc.next();

		change(s,t);
		if(possible) System.out.println(1);
		else System.out.println(0);
	}
	
	//s를 t로 바꾸는 연산 진행 >> s와 t가 같아지는 경우 possible true로 바꿔줌
	private static void change(String s, String t) {
		String S = s;
		
		//S와 t의 길이가 같아졌을 때 재귀 종료
		//두 단어가 같으면 possible = true로 바꿔줌
		if(S.length()==t.length()) {
			if(s.equals(t)) {
				possible = true;
				return;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		//만약에 t가 S나 S를 뒤집은 문자를 포함하지 않고 있다면 연산을 해도 S를 t로 만들 수 없으므로 재귀 종료
		if(!t.contains(S) && !t.contains(sb.append(S).reverse())) return;
		
		if(S.length()<t.length()) {
			//1. s 뒤에 a 추가
			sb = new StringBuilder();
			sb.append(s).append("A");
			S = sb.toString();
			change(S,t);
			//2. s 뒤에 b 추가하고 문자열 뒤집기
			sb = new StringBuilder();
			sb.append(s).append("B");
			sb.reverse();
			S = sb.toString();
			change(S,t);
		}
	}
}