import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class 보물상자비밀번호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//테스트 케이스 개수
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();//숫자 개수
			int K = sc.nextInt();//크기 순서
			
			//숫자 string으로 입력받아서 큐에 넣기
			String s = sc.next();
			Queue<Character> q = new ArrayDeque<>();
			for(int i=0; i<N; i++) {
				q.add(s.charAt(i));
			}
			
			Set<Integer> set = new HashSet<>();//가능한 비밀번호 중복 없이 넣을 집합

			for(int i=0; i<N/4; i++) {
				StringBuilder sb;
				for(int j=0; j<4; j++) {
					sb = new StringBuilder();
					for(int k=0; k<N/4; k++) {
						char c = q.poll();
						sb.append(c);
						q.add(c);
					}
					set.add(Integer.parseInt(sb.toString(),16));
				}
				q.add(q.poll());
			}
			
			List<Integer> pw = new ArrayList<Integer>(set);
			Collections.sort(pw, Comparator.reverseOrder());
			
			System.out.println("#"+tc+" "+pw.get(K-1));
			
		}

	}

}
