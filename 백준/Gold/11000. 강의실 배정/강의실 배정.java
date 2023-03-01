import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//수업 수
		
		int [][] arr = new int[N][2];//시작시간, 끝나는 시간 저장할 배열
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0]= Integer.parseInt(st.nextToken());//수업 시작 시간
			arr[i][1]= Integer.parseInt(st.nextToken());//수업 끝나는 시간
		}
        
		//수업 시작 시간 기준 정렬 & 시작 시간 같으면 끝나는 시간 기준으로 정렬
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return o1[1]-o2[1];
				
				return o1[0]-o2[0];	
			}
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(arr[0][1]);//배열의 첫번째 수업 끝나는 시간 우선순위큐에 넣어줌
		
		for(int i=1; i<N; i++) {
			//배열의 i번째 수업의 시작 시간이 우선순위큐에서 peek한 시간 이후면
			//같은 강의실 배정할 수 있으므로 우선순위큐에 들어있던 값 제거
			if(pq.peek()<=arr[i][0]) {
				pq.poll();
			}
			//우선순위 큐에 i번째 수업의 끝나는 시간 넣어줌
			pq.add(arr[i][1]);
		}
		//우선순위큐에 남아있는 원소의 개수 출력
		System.out.println(pq.size());
	}

}