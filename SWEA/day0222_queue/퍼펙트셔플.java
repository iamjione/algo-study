package day0222_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 퍼펙트셔플 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();//카드 개수
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			//1. 카드 절반 q1에 넣고 나머지 절반은 q2에 넣음
			if(N%2==0) {//N이 짝수일 때 q1에 절반 넣어줌
				for(int i=0; i<N/2; i++) q1.offer(sc.next());
			}else {//N이 홀수일 때 q1에 하나 더 넣어줌
				for(int i=0; i<N/2+1; i++) q1.offer(sc.next());
			}
			//q2에 나머지 넣어줌
			for(int i=0; i<N/2; i++) q2.offer(sc.next());
			
			// 2. q1과q2에서 번갈아 가면서 원소 하나씩 뻼
			for(int i=0; i<N/2; i++) {
				sb.append(q1.poll()).append(" ");
				sb.append(q2.poll()).append(" ");
			}
			//홀수면 q1에 원소 하나 더 있으니까 남은 하나까지 빼내줌
			if(N%2!=0) sb.append(q1.poll());

			System.out.println(sb);
		}

	}

}
