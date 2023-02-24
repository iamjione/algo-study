package day0222_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 회전 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();//숫자 개수
			int M = sc.nextInt();//작업 횟수
			
			Queue<Integer> q = new LinkedList<>();
			
			//큐에 숫자 넣기
			for(int i=0; i<N; i++) q.offer(sc.nextInt());
			//맨 앞의 숫자 뒤로 M번 보내기
			for(int i=0; i<M; i++) {
				int num = q.poll();
				q.offer(num);
			}
			//마지막에 제일 앞에 있는 숫자
			int ans = q.peek();
			System.out.println("#"+tc+" "+ans);
		}

	}

}
