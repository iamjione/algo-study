import java.util.Scanner;

public class Main {

	static StringBuilder sb;//패턴이 나타나는 위치 저장할 stringbuilder
	static int cnt;//패턴이 나타나는 횟수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String T = sc.nextLine();
		String P = sc.nextLine();
		
		kmp(T,P);
		
		System.out.println(cnt);
		System.out.println(sb);
	}

	//KMP : 모든 경우를 다 비교하지 않아도 패턴을 찾을 수 있는 알고리즘
	//접두사, 접미사를 활용한 실패 테이블을 만들어서 최대 한도로 점프
	private static void kmp(String text, String pattern) {
		int[] pi = getPi(pattern);
		
		sb = new StringBuilder();
		cnt = 0;
		
		int j = 0;//pattern의 인덱스
		for(int i=0; i<text.length(); i++) {//text의 인덱스
			//i와 j가 가르키는 값이 다르면 j를 점프시킴
			while(j>0 && text.charAt(i)!=pattern.charAt(j)) {
				j = pi[j-1];
			}
			
			if(text.charAt(i)==pattern.charAt(j)) {
				if(j==pattern.length()-1) {//패턴 찾은 경우
					j = pi[j];
					cnt++;//패턴 나타나는 횟수 카운트
					sb.append(i-pattern.length()+2).append(" ");//패턴 나타나는 위치 저장
				}else {
					j++;
				}
			}
		}
		
	}

	//실패 테이블
	private static int[] getPi(String pattern) {
		//접두사와 접미사가 일치하는 최대 길이를 담을 배열
		//0~i까지의 부분 문자열에서 접미사&접두사 일치하는 길이를 담음
		int[] pi = new int[pattern.length()];
		
		int j = 0;
		for(int i=1; i<pattern.length(); i++) {
			//i와 j가 가르키는 값이 다르면
			while(j>0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			//i와 j가 가르키는 값이 같으면
			//i번째의 최대 길이는 ++j한 값
			if(pattern.charAt(i)==pattern.charAt(j)) pi[i]=++j;
			
		}
		return pi;
	}

}