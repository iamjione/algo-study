package Day0404����Ǯ��;

import java.util.Scanner;

public class ���ο�����ν����ϴ��ɺ����� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();//������ ũ��
			
			int[][] arr = new int[N+2][N+2];//������ �迭
			
			//������ ���� �Է¹޾Ƽ� �迭�� ����
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			//���� �κ� 5�� ����
			for(int i=0; i<N+2; i++) {
				arr[0][i] = arr[N+1][i] = 5;
				arr[i][0] = arr[i][N+1] = 5;
			}
			
			//�����¿� ��Ÿ��
			int[] dr = {-1,1,0,0};
			int[] dc = {0,0,-1,1};
			
			int ans = 0;//������ ����� �ִ� ����
			
			//2���� �迭 ��ȸ
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					if(arr[i][j]==0) {//������̶�� ���� ����
						for(int k=0; k<4; k++) {//���� ���� �����¿�
							int score = 0;
							int nr = i;
							int nc = j;
							int dir = k;
							boolean end = false;//���� ���� ����
							
							while(true) {
								//��Ȧ/���/��Ȧ/�� ���� ������ �̵�
								while(arr[nr][nc]==0) {
									nr += dr[dir];
									nc += dc[dir];
									//�̵��ϴٰ� ���������� ���ƿ��� ������
									if(nr==i && nc==j) {
										end = true;
										break;
									}
								}
								
								if(end) break;
								
								//(nr,nc)�� ��Ȧ�� ���
								if(arr[nr][nc]==-1) {
									break;
								}
								//(nr,nc)�� 5�� ���
								else if(arr[nr][nc]==5) {
									score = score*2+1;
									break;
								}
								//(nr,nc)�� 1~4�� ����� ���
								else if(1<=arr[nr][nc] && arr[nr][nc]<=4) {
									int block = arr[nr][nc];//��� ��ȣ
									
									if(dir==0) {//���� �̵� ��
										if(block==1 || block==4) {
											score = score*2+1;
											break;
										}else if(block==2) {
											score++;
											dir=3;
											nc += dc[dir];
										}else {
											score++;
											dir=2;
											nc += dc[dir];
										}
									}else if(dir==1) {//�Ʒ��� �̵� ��
										if(block==2 || block==3) {
											score = score*2+1;
											break;
										}else if(block==1) {
											score++;
											dir=3;
											nc += dc[dir];
										}else {
											score++;
											dir=2;
											nc += dc[dir];
										}
									}else if(dir==2) {//�������� �̵� ��
										if(block==3 || block==4) {
											score = score*2+1;
											break;
										}else if(block==1) {
											score++;
											dir=0;
											nr += dr[dir];
										}else {
											score++;
											dir=1;
											nr += dr[dir];
										}
									}else {//���������� �̵� ��
										if(block==1 || block==2) {
											score = score*2+1;
											break;
										}else if(block==3) {
											score++;
											dir=1;
											nr += dr[dir];
										}else {
											score++;
											dir=0;
											nr += dr[dir];
										}
									}
								}
								//(nr,nc)�� ��Ȧ�� ���
								else {
									int num = arr[nr][nc];//��Ȧ ��ȣ
									for(int r=1; r<N+1; r++) {
										for(int c=1; c<N+1; c++) {
											if(arr[r][c]==num && (r!=nr || c!=nc)) {
												//�ݴ��� ��Ȧ�� �̵�
												nr = r+dr[dir];
												nc = c+dc[dir];
											}
										}
									}
								}
							}
							
							//�ְ��� ����
							if(score>ans) ans = score;
							
						}
					}
				}
			}
			
			System.out.println("#"+tc+" "+ans);
			
		}//tc
	}
}