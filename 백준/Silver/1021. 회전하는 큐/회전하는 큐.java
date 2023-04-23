import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//큐의 크기
		int M = sc.nextInt();//뽑아내려고 하는 수의 개수
		
        //인덱스 접근하기 위해 LinkedList로 deque구현
		LinkedList<Integer> dq = new LinkedList<>();
        //1부터 N까지 dq에 저장
		for(int i=1; i<=N; i++) {
			dq.add(i);
		}
		
        //뽑아내려는 숫자 입력받아서 arr 배열에 저장
		int[] arr = new int[M];
		for(int i=0; i<M; i++) {
			arr[i]=sc.nextInt();
		}
		
		int cnt = 0;//연산 수행 횟수
		int idx = 0;//arr의 인덱스
		while(idx<M) {
			if(dq.indexOf(arr[idx])<=dq.size()/2) {
				//arr[i]가 맨 앞에 올때까지 2번 연산 수행
				while(dq.indexOf(arr[idx])!=0) {
					dq.addLast(dq.pollFirst());
					cnt++;
				}
			}else {
				//arr[i]가 맨 앞에 올때까지 3번 연산 수행
				while(dq.indexOf(arr[idx])!=0) {
					dq.addFirst(dq.pollLast());
					cnt++;
				}
			}
			dq.pollFirst();//arr[i]가 맨 앞에 왔을 때 제거
			idx++;
		}
		System.out.println(cnt);
	}

}