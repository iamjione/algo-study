import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트 케이스 개수
		
        for(int tc = 0; tc<T; tc++) {
            
			int N = sc.nextInt(); //문서의 개수
			int idx = sc.nextInt(); //몇번째로 출력되는지 알고 싶은 문서의 위치
			Queue<Integer> q = new LinkedList<>();
			
			for(int i=0; i<N; i++) {
				q.offer(sc.nextInt());
			}//각 문서의 중요도 입력받기
			
			int cnt = 0;//답
			
			while(!q.isEmpty()) {
				//제일 앞에 값 빼냄
				int num = q.poll();
				//큐에서 빼낸 값이 최대값인지 확인
				int max = num;
				for(int x : q) {
					if(x>num) max = x;
				}
				
				boolean print = true;//프린트 여부
				
				//중요도가 제일 크지 않은 경우 다시 큐에 넣어주고
				//프린트 안했다고 표시해줌
				if(max!=num) {
					q.offer(num);
					print=false;
				//중요도가 제일 큰 경우 카운트 올려줌
				}else cnt++;
				
				//인덱스 0아니면 찾는 문서의 위치 -1해줌
				if(idx!=0) idx--;
				//인덱스 0인 경우 그 값이 프린트되었으면 while문 종료하고 cnt출력
				//프린트 되지않은 경우 idx==(큐의 사이즈-1)
				else {
					if(print==true) {
						System.out.println(cnt);
						break;
					}else{
						idx = q.size()-1;
					}
				}
			}
		}
	}
}