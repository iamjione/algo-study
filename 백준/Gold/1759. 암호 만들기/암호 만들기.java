import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int L, C;
	static char[] alphabet;
	static char[] code;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt(); // 암호 길이
		C = sc.nextInt(); // 주어진 문자 개수
		
		alphabet = new char[C];
		for(int i=0; i<C; i++) {
			alphabet[i] = sc.next().charAt(0);
		}
		Arrays.sort(alphabet);
		
		code = new char[L];
		
		makeCode(0, 0);
		
		System.out.println(sb.toString());
	}

	private static void makeCode(int idx, int start) {
		if(idx == L) {
			if(valid()) {
				for(int i=0; i<L; i++) {
					sb.append(code[i]);
				}
				sb.append('\n');
			}
			
			return;
		}
		
		for(int i=start; i<C; i++) {
			code[idx] = alphabet[i];
			makeCode(idx+1, i+1);
		}
		
	}

	// 최소 한개의 모음, 최소 두개의 자음으로 구성되어 있는지 확인
	private static boolean valid() {
		int v = 0; // 모음 개수
		int c = 0; // 자음 개수
		
		for(int i=0; i<L; i++) {
			if(code[i]=='a' || code[i]=='e' || code[i]=='i' || code[i]=='o' || code[i]=='u') v++;
			else c++;
		}
		
		if(v>=1 && c>=2) return true;
		
		return false;
	}

}