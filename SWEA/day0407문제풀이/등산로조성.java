package day0407����Ǯ��;

import java.util.Scanner;

public class �������� {

	static int N, K, ans;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();//���� ũ��
			K = sc.nextInt();//�ִ� ���� ���� ����
			
			int max = 0;//���� ���� ���츮�� ����
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
					//1. ���ǹ�
					if(arr[i][j]>max) max = arr[i][j];
					//2. max�޼���
//					max = Math.max(max, arr[i][j]);
					//3. ���� ������
//					max = max<arr[i][j]?arr[i][j]:max;
				}
			}
			
			ans = 0;//������ ����� ��
			visited = new boolean[N][N];//�湮ǥ���� �迭
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j]==max) DFS(i,j,1,false);
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}//tc

	}//main

	//i:��, j:�� len:���� ���� construct:���� ����
	private static void DFS(int i, int j, int len, boolean construct) {
		//���� ���� ���� ����
		if(len>ans) ans = len;
		
		visited[i][j] = true;//�湮üũ
		
		for(int d=0; d<4; d++) {
			int nr = i+dr[d];
			int nc = j+dc[d];
			
			//�迭 ����ų� �湮������ ��Ƽ��
			if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) continue;
			
			//(nr,nc)�� ���� ��ġ���� ������ DFS����
			if(arr[nr][nc]<arr[i][j]) DFS(nr,nc, len+1, construct);
			//(nr,nc)�� ���� ��ġ���� ������ ���� ���� �� ��� �����ϰ� DFS����
			else if(!construct && arr[i][j]>arr[nr][nc]-K) {
				int tmp = arr[nr][nc];//���� ���� �ӽ� ����
				arr[nr][nc] = arr[i][j]-1;//�����ϱ�
				DFS(nr,nc, len+1, true);
				arr[nr][nc] = tmp;//���� ���� ����
			}
		}
		visited[i][j] = false;//�湮 üũ ���� ����
	}

}
