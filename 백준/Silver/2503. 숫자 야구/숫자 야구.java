import java.util.Scanner;

public class Main {

	static Hint[] hints;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //질문 횟수
		
		hints = new Hint[N];
		for(int i=0; i<N; i++) {
			hints[i] = new Hint(sc.next(), sc.nextInt(), sc.nextInt());
		}
		
		int cnt = 0;
		StringBuilder sb;
		for(int i=1; i<=9; i++) {
			sb = new StringBuilder();
			sb.append(i);
			for(int j=1; j<=9; j++) {
				if(i==j) continue;
				sb.append(j);
				for(int k=1; k<=9; k++) {
					if(i==k || j==k) continue;
					sb.append(k);
					if(isValid(sb.toString())) cnt++;
					sb.deleteCharAt(2);
				}
				sb.deleteCharAt(1);
			}
		}
		System.out.println(cnt);
	}
	
	private static boolean isValid(String n) {
		for(Hint h : hints) {
			int strike = 0;
			int ball = 0;
			
			for(int i=0; i<3; i++) {
				if(h.num.charAt(i) == n.charAt(i)) {
					strike++;
				} else {
					for(int j=0; j<3; j++) {
						if(h.num.charAt(j) == n.charAt(i)) {
							ball++;
							break;
						}
					}
				}
			}
			
			if(strike != h.s || ball != h.b) return false;
		}
		
		return true;
	}

	private static class Hint {
		String num;
		int s;
		int b;
		
		private Hint(String num, int s, int b) {
			this.num = num;
			this.s = s;
			this.b = b;
		}
	}

}