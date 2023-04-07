package Day0406����Ǯ��;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Ż�ֹ��˰� {

	static int N, M, R, C, L, cnt;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();//���� ũ��
			M = sc.nextInt();//���� ũ��
			
			R = sc.nextInt();//��Ȧ ���� ��ġ
			C = sc.nextInt();//��Ȧ ���� ��ġ
			L = sc.nextInt();//Ż�� �� �ҿ� �ð�
			
			//�����ͳ� ���� �Է¹ޱ�
			arr = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			cnt = 0;
			visited = new boolean[N][M];
			bfs();
			System.out.println("#"+tc+" "+cnt);
		}//tc

	}

	private static void bfs() {
		Queue<RC> q = new ArrayDeque<>();
		
		q.offer(new RC(R,C,1));//��Ȧ ��ġ ť�� �־���
		visited[R][C] = true;//�湮 ǥ��
		
		
		while(!q.isEmpty()) {
			//ť���� �湮�� ��ġ poll
			RC rc = q.poll();
			int r = rc.r;
			int c = rc.c;
			
			//(r,c)���� ���µ� L���� �����ɸ��ٸ� ���̻� �� �ʿ� �����Ƿ� ����
			if(rc.time>L) return;
			
			cnt++;//�湮�� ������ Ż�ֹ������� �� �ִ� ��� �� ī��Ʈ
			
			//(r,c)���� �� �� �ִ� �� �湮
			for(int i=0; i<4; i++) {
				int nr = r+dr[i];//�̵� ��ġ ��
				int nc = c+dc[i];//�̵� ��ġ ��
				
				
				//�迭 ���� ����ų� �湮�� �� �Ǵ� �� �����̸� ��Ƽ��
				if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc] || arr[nr][nc]==0) continue;
				
				int curr = arr[r][c];//(r,c)�� ������ ��ȣ

				if(curr==2 &&(i==2||i==3)) continue;//2�� ���������� �¿�� �̵� ���ϹǷ� ��Ƽ��
				else if(curr==3 && (i==0||i==1)) continue;//3�� ���������� ���Ϸ� �̵� ���ϹǷ� ��Ƽ��		
				else if(curr==4 &&(i==1||i==2)) continue;//4�� ���������� ���·� �̵� ���ϴϱ� ��Ƽ��
				else if(curr==5 &&(i==0||i==2)) continue;//5�� ���������� ���·� �̵� ���ϴϱ� ��Ƽ�� 
				else if(curr==6 &&(i==0||i==3)) continue;//6�� ���������� ���� �̵� ���ϴϱ� ��Ƽ��
				else if(curr==7 &&(i==1||i==3)) continue;//7�� ���������� �Ͽ�� �̵� ���ϴϱ� ��Ƽ��
					
				int next = arr[nr][nc];//�̵��� ���� ������ ��ȣ				

				//���� �̵� ����(i)�� �������� �� �� ���� �������̸� ��Ƽ��
				if(i==0 && (next==3||next==4||next==7)) continue;
				if(i==1 && (next==3||next==5||next==6)) continue;
				if(i==2 && (next==2||next==6||next==7)) continue;
				if(i==3 && (next==2||next==4||next==5)) continue;
				
				//�� �� �ִ� ���̸� ť�� �־��ֱ� & �湮 üũ
				q.offer(new RC(nr,nc,rc.time+1));
				visited[nr][nc]=true;
			}	
		}
	}

	static class RC {
		int r, c, time;

		public RC(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
}
