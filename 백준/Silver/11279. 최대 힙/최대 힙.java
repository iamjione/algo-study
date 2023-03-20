import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//연산 횟수

		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		
		int cmd;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			cmd = Integer.parseInt(br.readLine());//연산 정보 입력받기
			switch(cmd) {
			case 0://0인 경우
				if(pq.isEmpty()) sb.append(0).append('\n');//우선순위큐가 비어있다면 0 출력
				else sb.append(pq.poll()).append('\n');//우선순위큐에 값이 있다면 가장 큰 값 출력
				break;
			default://0이 아닌 자연수가 주어지는 경우
				pq.add(cmd);//우선순위큐에 넣음
			}
		}
		System.out.println(sb);
	}

}