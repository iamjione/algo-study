package day0222_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 피자굽기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt();//화덕 크기
			int M = sc.nextInt();//피자 개수
			
			Queue<Integer> cheeze = new LinkedList<>();
			Queue<Integer> Idx = new LinkedList<>();
			Queue<Integer> oven = new LinkedList<>();
			
			for(int i=0; i<M; i++) cheeze.offer(sc.nextInt());
			for(int i=0; i<N; i++) oven.offer(cheeze.poll());
			for(int i=1; i<=N; i++) Idx.offer(i);
			int index = N;//마지막으로 화덕에 들어간 피자의 인덱스
			
			while(Idx.size()>1) {
				if(oven.peek()==1) {
					//치즈 녹았으면 피자 빼내기
					oven.poll();
					Idx.poll();
					//화덕에 안들어간 피자 남아있으면 넣어주기
					if(!cheeze.isEmpty()) {
						oven.offer(cheeze.poll());
						Idx.offer(++N);
					}
				}else {//치즈 아직 안 녹았으면
					oven.offer(oven.poll()/2);
					Idx.offer(Idx.poll());
				}	
			}
			
			System.out.println("#"+tc+" "+Idx.peek());
		}

	}

}
