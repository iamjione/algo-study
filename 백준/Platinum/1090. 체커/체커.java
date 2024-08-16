import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	static int N;
	static int[][] arr;
	static Set<Integer> setX, setY;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N][2];
		
		setX = new HashSet<>();
		setY = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			
			setX.add(arr[i][0]);
			setY.add(arr[i][1]);
		}
		
		int[] answer = new int[N];
		
		int min, sum;
		PriorityQueue<Integer> pq;
		
		for(int i=1; i<N; i++) {//i+1: 같은 칸으로 모여야할 체커의 최소 개수
			min = Integer.MAX_VALUE;		
			
			for(int x : setX) {
				for(int y : setY) {
					sum = 0;
					pq = new PriorityQueue<>();
					
					// x, y로 모을 때 각 체커의 이동 거리 계산해서 pq에 넣기
					for(int j=0; j<N; j++) {
						pq.offer(Math.abs(x-arr[j][0]) + Math.abs(y-arr[j][1]));
					}
					
					// 그 중 이동 거리 최소인 i+1개의 수 더해서 min값 갱신
					for(int j=0; j<i+1; j++) {
						sum += pq.poll();
					}
					
					min = Math.min(min, sum);
				}
			}
			
			answer[i] = min;
		}
		
		
		// 답 출력
		StringBuilder sb = new StringBuilder();
		for(int ans : answer) sb.append(ans+" ");
		
		System.out.println(sb.toString());
		
	}

}