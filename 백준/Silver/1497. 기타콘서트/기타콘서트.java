import java.util.Scanner;

public class Main {

	static int N, M;
	static boolean[][] arr;
	static int min = Integer.MAX_VALUE; // 기타 최소 개수
	static int max = 0; // 연주할 수 있는 곡 최대 개수
	static int[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 기타 개수
		M = sc.nextInt(); // 곡 수
		
		arr = new boolean[N][M];
		for(int i=0; i<N; i++) {
			sc.next();
			String s = sc.next();
			for(int j=0; j<M; j++) {
				if(s.charAt(j)=='Y') arr[i][j] = true;
			}
		}
		
		visited = new int[M];
		
		recur(0, 0);
		
		if(max==0) System.out.println(-1);
		else System.out.println(min);
	}

	private static void recur(int idx, int cnt) {
		if(min<cnt) return;
		
		if(idx==N) {
			int song = 0;
			for(int i=0; i<M; i++) {
				if(visited[i]>0) song++;
			}
			
			if(song>0){
				if(song>max) {
					// 연주할 수 있는 곡 수 최대면 기타 수 바로 cnt로 갱신
					max = song;
					min = cnt;
				}else if(song==max) {
					// 연주할 수 있는 곡 수 기존과 같으면 cnt와 min 비교
					min = Math.min(min, cnt);					
				}
			}
			return;
		}
		
		// idx번째 기타 구매하는 경우
		// idx번째 기타로 연주할 수 있는 곡 표시
		for(int i=0; i<M; i++) {
			if(arr[idx][i]) visited[i]++;
		}
		recur(idx+1, cnt+1);
		
		// 원상복구
		for(int i=0; i<M; i++) {
			if(arr[idx][i]) visited[i]--;
		}
		
		
		// idx번째 기타 구매하지 않는 경우
		recur(idx+1, cnt);
		
	}

}