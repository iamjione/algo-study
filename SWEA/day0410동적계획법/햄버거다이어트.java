package day0410������ȹ��;

import java.util.Scanner;

public class �ܹ��Ŵ��̾�Ʈ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();//��� ����
			int L = sc.nextInt();//���� Į�θ�
			
			//��Ằ ������ Į�θ� �Է¹޾Ƽ� �迭�� ����
			int[] score = new int[N+1];
			int[] cal = new int[N+1];
			for(int i=1; i<=N; i++) {
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			
			int[][] dp = new int[N+1][L+1];
			for(int i=1; i<=N; i++) {//��� �ϳ��� �÷����鼭 ���
				for(int j=0; j<=L; j++) {//j: ���� Į�θ�
					if(cal[i] <= j) {//����Į�θ����� i��° ����� Į�θ��� ���� ��� i��° ��� �߰��� �� ����
						//i��° ��� ���� ���� ���� ���� ��� �� ������ �� ū ���� dp[i][j]�� ����
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cal[i]]+score[i]);
					}else {//Į�θ� ���Ѷ����� i��° ��Ḧ ���� �� ���� ��� ������ ������ �ּ��� ���
						dp[i][j]=dp[i-1][j];
					}
				}
			}
			System.out.println("#"+tc+" "+dp[N][L]);
		}//tc

	}

}
