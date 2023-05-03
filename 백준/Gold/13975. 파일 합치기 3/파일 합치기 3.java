import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//테스트케이스 수
		StringBuilder sb = new StringBuilder();
		for(int tc=0; tc<T; tc++) {
			int N = sc.nextInt();//소설을 구성하는 장의 수
			
			//각 장의 파일 크기입력받아서 우선순위 큐에 넣기
			PriorityQueue<Long> pq = new PriorityQueue<>();
			for(int i=0; i<N; i++) {
				pq.add(sc.nextLong());
			}
			
			long cost = 0;//모든 장을 합치는 최소 비용
			
			//비용 최소로 하려면 크기가 작은 두 묶음부터 차례대로 합쳐야함
			//따라서 우선순위 큐가 빌때까지 두 수 뽑아서 더한 값을 cost에 더해주고 
			//다시 우선 순위큐에 넣어주는 것을 반복하면 최소비용을 구할 수 있음
			while(pq.size()>1) {//파일이 2개 이상일 때만 반복문 실행
				long tmp = pq.poll()+pq.poll();
				cost+=tmp;
				pq.add(tmp);
			}
			
			sb.append(cost).append('\n');
		}
		System.out.println(sb);
	}

}