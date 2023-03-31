package 문제풀이;

import java.util.Scanner;

public class 최적경로 {

	static int N, min;
	static location[] arr, order;
	static boolean[] visited;
	static location office, home;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//테스트케이스 수
		
		for(int tc=1; tc<=T; tc++) {
			N =sc.nextInt();//고객의 수
			
			//회사 위치 & 집 위치 입력받아서 location 객체로 저장
			office = new location(sc.nextInt(), sc.nextInt());
			home = new location(sc.nextInt(), sc.nextInt());
			
			//N명의 고객 위치 입력받아서 배열에 저장
			arr = new location[N];
			for(int i=0; i<N; i++) {
				arr[i] = new location(sc.nextInt(), sc.nextInt());
			}
			
			visited = new boolean[N];//방문 체크할 배열
			order = new location[N];//방문 순서 표시할 배열
			min = Integer.MAX_VALUE;//최단 이동거리
			
			order(0);
			
			System.out.println("#"+tc+" "+min);

		}//tc

	}
	
	//방문 순서 정하기
	private static void order(int idx) {
		if(idx==N) {
			distance();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			
			//방문하지 않은 곳이면 방문하기
			visited[i] = true;
			order[idx] = arr[i]; 
			
			order(idx+1);//다음 방문할 곳 정하기
			
			//원상복구
			visited[i] = false;
		}	
	}

	//총 이동 거리 구하고 최소값 갱신하는 메서드
	private static void distance() {
		int cnt = cal(office, order[0]);//회사랑 첫번째 고객 사이 이동거리
		cnt += cal(order[N-1], home);//마지막 고객과 집 사이의 이동거리
		//1번 부터 N번 고객까지의 이동 거리
		for(int i=0; i<N-1; i++) {
			cnt += cal(order[i], order[i+1]);
		}
		//최소값 갱신
		if(cnt<min) min=cnt;
	}

	//두 점 사이 이동거리 계산하기
	private static int cal(location a, location b) {
		return Math.abs(a.x-b.x) + Math.abs(a.y-b.y);
	}

	//위치 객체
	static class location{
		int x;
		int y;
		
		public location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}