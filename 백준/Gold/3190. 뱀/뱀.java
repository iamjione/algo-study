import java.util.Scanner;

public class Main {

	private static class info{
		//n: 1벽 or 뱀, 2:사과
		//d: 0상,1하,2좌,3우,-1방향정보 없음
		int n,d;

		public info(int n, int d) {
			this.n = n;
			this.d = d;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//보드 크기
		info[][] arr = new info[N][N];//보드
		
		int M = sc.nextInt();//사과 개수
		//사과 위치 저장
		for(int i=0; i<M; i++) {
			arr[sc.nextInt()-1][sc.nextInt()-1] = new info(2,-1);
		}
		
		int L = sc.nextInt();//방향 전환 횟수
		//방향 정보 저장(-1:왼쪽, 1:오른쪽)
		int[][] turn = new int[L][2];
		for(int i=0; i<L; i++) {
			turn[i][0] = sc.nextInt();
			char c = sc.next().charAt(0);
			if(c=='L') turn[i][1] = -1;
			else turn[i][1] = 1;
		}
		
		//4방탐색 델타값
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		//상하좌우 방향보다가 왼쪽,오른쪽으로 회전했을 때 방향
		int[] idxL = {2,3,1,0};
		int[] idxR = {3,2,0,1};
		
		int time = 0;
		//(r,c): 머리 위치
		int r = 0;
		int c = 0;
		int d = 3;//시작 방뱡
		//(tr,tc): 꼬리 위치
		int tr = 0;
		int tc = 0;
		int td = d;//꼬리 방향
		arr[r][c] = new info(1,d);//시작점 표시
		int idxI = 0;//turn배열의 인덱스
		
		while(true) {
			time++;
			
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N) {
				//벽이랑 부딪히면 게임 끝
				break;
			}else if(arr[nr][nc] == null) {
				//빈칸이라면 한칸 이동하고
				r = nr;
				c = nc;
				arr[r][c]=new info(1,d);
				//새로운 꼬리 위치 저장 후 꼬리도 한칸 이동
				td = arr[tr][tc].d;
				arr[tr][tc]=null;
				tr = tr+dr[td];
				tc = tc+dc[td];
			}else if(arr[nr][nc].n == 1){
				//뱀이 자기 자신과 부딪히면 게임 끝
				break;
			}else {
				//사과 있다면 이동 후 사과 없어지고 꼬리 그대로
				r = nr;
				c = nc;
				arr[r][c]=new info(1,d);
			}
			
			//방향 변환 정보 있으면 방향 바꾸기
			if(idxI<L && turn[idxI][0]==time) {
				if(turn[idxI][1]==-1) d = idxL[d];
				else d = idxR[d];
				
				arr[r][c].d=d;
				idxI++;
			}
		}
		System.out.println(time);
	}

}