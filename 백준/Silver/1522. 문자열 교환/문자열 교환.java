import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] str = sc.next().toCharArray();
		
		// 문자열 내 a 개수 카운트
		int cntA = 0;
		for(char c : str) {
			if(c=='a') cntA++;
		}
		
		int min = Integer.MAX_VALUE; // 교환 횟수의 최솟값
		int cntB;// 탐색 범위 내 b의 개수
		
		// cntA 만큼의 길이 내에 b의 개수 카운트 => 최소값 찾기
		for(int i=0; i<str.length; i++) {
			cntB = 0;
			for(int j=i; j<i+cntA; j++) {
				// 문자열의 처음과 끝이 인접해있기 때문에 전체 길이를 나눈 나머지로 인덱스 설정 
				if(str[j%str.length]=='b') cntB++;
			}
			min = Math.min(min,  cntB);
		}

		System.out.println(min);
	}

}