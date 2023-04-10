package day0404����Ǯ��;

import java.util.Scanner;

public class �ɺ����� {

	static int N, max, score;
	static int[][] arr;
	//�����¿� ��Ÿ��
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();//������ ũ��
			arr = new int[N+2][N+2];
			
			//�� 11�� ����
			for(int i=0; i<N+2; i++) {
				arr[0][i] = arr[N+1][i] = 11;
				arr[i][0] = arr[i][N+1] = 11;
			}
			
			//������ ���� �Է¹޾Ƽ� �迭�� ����
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			max = 0;//������ �ִ밪 �ʱ�ȭ
			
			//2���� �迭�� ��ȸ�ϸ鼭 ���� ������ ������ ��� ĭ���� ���� �����غ���
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					if(arr[i][j]==0) {//��ĭ�̸� ���� ���� ����
						for(int k=0; k<4; k++) {//���� ����
							score = 0;
							int row = i;
							int col = j;
							int d = k;
							while(true) {
								int nr = row+dr[d];
								int nc = col+dc[d];
								int idx = 1;
								while(arr[nr][nc]==0) {
									nr = row+dr[d]*idx;
									nc = col+dc[d]*idx;
									idx++;
								}
								
								//��Ȧ �����ų� ��������� ���ƿ����� ������ �ִ밪 �������ְ� ���� ����
								if(arr[nr][nc]==-1 || (nr==i&&nc==j)) {
									if(max<score) max = score;
									break;
									
								//5�� ����̳� �� �������� ���� ���� ��� �� �ִ밪 �������ְ� ���� ����
								}else if(arr[nr][nc]==5 || arr[nr][nc]==11) {
									score = score*2+1;
									if(max<score) max = score;
									break;
									
								//1��~4�� ��� ���� ���
								}else if(1<=arr[nr][nc] && arr[nr][nc]<=4) {
									switch(d) {
									case 0://���� �̵� ��
										if(arr[nr][nc]==1 || arr[nr][nc] == 4) {
											//1��, 4�� ��� �������� ���� ����
											score = score*2+1;
											if(max<score) max = score;
											break;
										}else {
											//1�� ȹ�� && �̵� ���� �ٲٱ�
											score++;
											row = nr;
											col = nc;
											if(arr[nr][nc]==2) d=3; 
											else if(arr[nr][nc]==3) d=2;
										}
										break;
									case 1://�Ʒ��� �̵� ��
										if(arr[nr][nc]==2 || arr[nr][nc] == 3) {
											//2��, 3�� ��� �������� ���� ����
											score = score*2+1;
											if(max<score) max = score;
											break;
										}else {
											//1�� ȹ�� && �̵� ���� �ٲٱ�
											score++;
											row = nr;
											col = nc;
											if(arr[nr][nc]==1) d=3;
											else if(arr[nr][nc]==4) d=2;
										}
										break;
									case 2://�������� �̵� ��
										if(arr[nr][nc]==3 || arr[nr][nc]==4) {
											//3��,4�� ��� �������� ���� ����
											score = score*2+1;
											if(max<score) max = score;
											break;
										}else {
											//1�� ȹ�� && �̵� ���� �ٲٱ�
											score++;
											row = nr;
											col = nc;
											if(arr[nr][nc]==1) d=0;
											else if(arr[nr][nc]==2) d=1;
										}
										break;
									default://���������� �̵� ��
										if(arr[nr][nc]==1 || arr[nr][nc]==2) {
											//1�� ��� �������� ���� ����
											score = score*2+1;
											if(max<score) max = score;
											break;
										}else {
											//1�� ȹ�� && �̵� ���� �ٲٱ�
											score++;
											row = nr;
											col = nc;
											if(arr[nr][nc]==3) d=1;
											else if(arr[nr][nc]==4) d=0;
										}
										break;
									}
								}else{
									//��Ȧ�̸� �ݴ��� ��Ȧ�� ������
									for(int r=1; r<N+1; r++) {
										for(int c=1; c<N+1; c++) {
											if(r!=nr || c!=nc && arr[nr][nc]==arr[r][c]) {
												//nr,nc ���� r,c�� �̵�
												row = r;
												col = c;
											}
										}
									}
								}
							}
						}
					}
				}
			}
			System.out.println("#"+tc+" "+max);
		}//tc

	}


//	private static void gameStop(int score) {
//		//����̳� ���� ������ �̵� ������ ���� �ݴ�� �ٲ�� �Դ� �� �ǵ��ư��⶧����
//		//���ݱ��� ������ 2�� +1 ���� ���� ����!
//		score = score*2+1;
//		if(max<score) max = score;
//	}
	
	

}
