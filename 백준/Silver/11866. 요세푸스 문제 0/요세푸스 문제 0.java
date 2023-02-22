import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//숫자 개수
		int K = sc.nextInt();//K번째 숫자 제거

		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}//큐에 숫자 입력하기
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		//큐에 원소 하나 남을 때까지 맨 앞 값 빼서 뒤에 넣어주기 K-1번 반복하고
		//K번째 값 빼서 StringBuilder에 추가해줌
		while(q.size()>1) {
			for(int i=0; i<K-1; i++) q.offer(q.poll());
			sb.append(q.poll()).append(",").append(" ");
		}
		sb.append(q.poll()).append(">");
		
		System.out.println(sb);
	}
}