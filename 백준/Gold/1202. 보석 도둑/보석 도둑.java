import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//보석 개수
		int K = sc.nextInt();//가방 개수
		
		//보석 정보 저장
		Jewelry[] jewels = new Jewelry[N];
		for(int i=0; i<N; i++) {
			int M = sc.nextInt();//보석 무게
			int V = sc.nextInt();//보석 가격
			jewels[i] = new Jewelry(M,V);
		}
		Arrays.sort(jewels);
		
		//가방에 담을 수 있는 최대 무게 저장
		int[] bags = new int[K];
		for(int i=0; i<K; i++) bags[i] = sc.nextInt();
		Arrays.sort(bags);
		
		long max = 0;//훔칠 수 있는 보석의 최대 가격
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());//가격 높은 순으로 정렬
		int idx = 0;
		for(int i=0; i<K; i++) {
			//담을 수 있는 무게 작은 가방부터 그 가방에 담을 수 있는 모든 보석들 우선순위큐에 넣음
			while(idx<N && jewels[idx].M <= bags[i]) {
				pq.add(jewels[idx++].V);
			}
			
			//우선순위큐에 들어있는 보석 중 가장 비싼 보석의 가격 max에 더해줌
			if(!pq.isEmpty()) max += pq.poll();
		}

		System.out.println(max);
	}

	private static class Jewelry implements Comparable<Jewelry>{
		int M, V;
		
		public Jewelry(int M, int V) {
			this.M = M;
			this.V = V;
		}

		//무게 가벼운 순 && 가격 높은 순 정렬
		@Override
		public int compareTo(Jewelry o) {
			if(this.M==o.M) return o.V-this.V;
			return this.M - o.M;
		}
		
		
	}
}