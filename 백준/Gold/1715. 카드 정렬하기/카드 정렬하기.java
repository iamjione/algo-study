import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//숫자 카드 묶음의 개수
		
		//카드 묶음의 크기 우선순위 큐에 넣기
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			pq.add(sc.nextInt());
		}
		
		int cnt = 0;//비교 횟수
		
		//비교 횟수 최소로 하려면 크기가 작은 두 묶음부터 차례대로 합쳐야함
		//따라서 우선순위 큐가 빌때까지 두 수 뽑아서 더한 값을 비교횟수에 더해주고 
		//다시 우선 순위큐에 넣어주는 것을 반복하면 최소 비교횟수를 구할 수 있음
		while(N>1) {//카드 묶음이 2개 이상일 때만 반복문 실행
			int tmp = pq.poll()+pq.poll();
			cnt+=tmp;
			if(pq.isEmpty()) break;
			pq.add(tmp);
		}
		
		System.out.println(cnt);
	}

}