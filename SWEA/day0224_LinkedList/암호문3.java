package day0224_LinkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class 암호문3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int N = sc.nextInt();//암호문의 길이 N
			LinkedList<Integer> list = new LinkedList<>();
			
			for(int i=0; i<N; i++) {
				list.add(sc.nextInt());
			}
			
			int M = sc.nextInt();//명령어의 개수
			for(int i=0; i<M; i++) {
				String order = sc.next();//명령어
				switch(order) {
				case "I"://x의 위치 다음에 y개의 숫자 삽입
					int x = sc.nextInt();
					int y = sc.nextInt();
					for(int j=0; j<y; j++) {
						int s = sc.nextInt();
						list.add(x+j, s);
					}
					break;
				case "D"://x의 위치 다음부터 y개의 숫자 삭제
					int x2 = sc.nextInt();
					int y2 = sc.nextInt();
					for(int j=0; j<y2; j++) {
						list.remove(x2+1);
					}
					break;
				case "A"://맨뒤에 y개의 숫자 덧붙임
					int y3 = sc.nextInt();
					for(int j=0; j<y3; j++) {
						int s = sc.nextInt();
						list.add(s);
					}	
				}
			}
			System.out.print("#"+tc);
			for(int i=0; i<10; i++) {
				System.out.print(" "+list.poll());
			}
			System.out.println();		
		}
	}
}