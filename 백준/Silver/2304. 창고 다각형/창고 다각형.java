import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt(); // 기둥 왼쪽 면 위치
			arr[i][1] = sc.nextInt(); // 기둥 높이
		}
		
		Arrays.sort(arr, (a, b)->a[0]-b[0]); // 기둥 왼쪽면 기준 정렬
		
		Stack<int[]> stack = new Stack<>();
		stack.push(arr[0]);
		
		int answer = 0;
		int idx = 1;
		int lastIdx = 0; // 마지막으로 스택에 들어간 값의 인덱스
		while(idx<N) {
			if(arr[idx][1] >= stack.peek()[1]) {
				answer += (arr[idx][0]-stack.peek()[0])*stack.peek()[1];
				stack.pop();
				stack.push(arr[idx]);
				lastIdx = idx;
			}
			
			idx++;
		}
		
		answer += arr[lastIdx][1];
		stack.pop();
		
		stack.push(arr[N-1]);
		idx = N-2;
		while(idx>=lastIdx) {
			if(arr[idx][1] >= stack.peek()[1]) {
				answer += (stack.peek()[0]-arr[idx][0])*stack.peek()[1];
				stack.pop();
				stack.push(arr[idx]);
			}
			
			idx--;
		}
		
		System.out.println(answer);
	}

}