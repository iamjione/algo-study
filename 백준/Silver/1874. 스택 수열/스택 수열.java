import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Stack<Integer> stack = new Stack<>();
		
		List<String> al = new ArrayList<>();//출력할 답 담을 리스트


		int index = 0;//배열 인덱스
		
		for(int i=1; i<N+1; i++) {
			stack.push(i);
			al.add("+");
			while(!stack.isEmpty()) {
				if(stack.peek()==arr[index]) {
					stack.pop();
					al.add("-");
					index++;
				} else break;
			}
			
		}
		
		if(!stack.isEmpty()) {
			System.out.println("NO");
		}else{
			for(String x: al) {
				System.out.println(x);
		}
			
		}

	}
}
