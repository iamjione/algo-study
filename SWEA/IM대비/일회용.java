package IM대비;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 일회용 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();//신입사원수
			int k_min = sc.nextInt();//각 분반별 최소 인원
			int k_max = sc.nextInt();//각 분반별 최대 인원
			Queue<Integer> q = new LinkedList<>();//어학 성적
			
			int min = 100;//최소점수
			int max = 0;//최대점수
			for(int i=0; i<N; i++) {
				int score = sc.nextInt();
				q.add(score);
				if(score>max) max = score;
				if(score<min) min = score;
			}
			
			int diff = 1000;//신입 사원 가장 많은 반과 적은 반의 인원수 차이 최소값
			
			for(int i=1; i<N-1; i++) {
				int T1 = min+i;
				for(int j=i+1; j<N; j++) {
					int T2 = min+j;
					if(T2>max) break;
					
					Queue<Integer> q2 = new LinkedList<>();
					for(int x:q) q2.add(x);//q2에서 값 제거하면 q에서도 제거되니까 깊은 복사 해주기
					
					int[] num = new int[3];//A B C반 인원수
					
					//점수 T2 이상이면 A반에 배정
					for(int k=0; k<N; k++) {
						if(q2.peek()>=T2) {
							q2.poll();
							num[0]++;
						}else q2.add(q2.poll());
					}
					//A반에 배정된 사람 k_min~k_max명 아니면 컨티뉴
					if(num[0]<k_min || num[0]>k_max) continue;
					
					//점수 T1 이상이면 B반에 배정
					int size = q2.size();
					for(int k=0; k<size; k++) {
						if(q2.peek()>=T1) {
							q2.poll();
							num[1]++;
						}else q2.add(q2.poll());
					}
					//B반에 배정된 사람 k_min~k_max명 아니면 컨티뉴
					if(num[1]<k_min || num[1]>k_max) continue;
					
					//나머지 C반 배정
					num[2] = q2.size();
					//C반에 배정된 사람 k_min~k_max명 아니면 컨티뉴
					if(num[2]<k_min || num[2]>k_max) continue;
						
					Arrays.sort(num);
					if(num[2]-num[0] < diff) diff = num[2]-num[0];
				}
			}
			
			if(diff==1000) System.out.println("#"+tc+" -1");
			else System.out.println("#"+tc+" "+diff);
	
		}

	}

}
