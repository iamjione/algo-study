import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 빌딩 개수
		long cnt = 0; // 각 관리인이 벤치마킹 가능한 빌딩의 수
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			int h = sc.nextInt();
			
			while(!stack.isEmpty()) {
				if(stack.peek() <= h) {
					stack.pop();
				}else {
					break;
				}
			}
			
			cnt += stack.size();
			
			stack.push(h);
		}
		
		System.out.println(cnt);
	}

}