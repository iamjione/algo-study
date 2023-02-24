package day0223_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 암호생성기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int T = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			
			for(int i=0; i<8; i++) {
				q.add(sc.nextInt());
			}

			boolean noZero = true;//0이 나오면 false로 바꿀거임
			while(noZero) {
				//i만큼 뺏을 때 0보다 크면 i만큼 뺀 값 넣어주고
				//음수나 0이면 0으로 넣어주고 0나왔다고 체크하고 while문 빠져나옴
				for(int i=1; i<=5;i++) {
					if(q.peek()-i>0) q.add(q.poll()-i);
					else {
						q.poll();
						q.add(0);
						noZero = false;
						break;
					}
				}
			}
			
			System.out.print("#"+T+" ");
			for(int x:q) System.out.print(x+" ");
			System.out.println();

		}

	}

}
