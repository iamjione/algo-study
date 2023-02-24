import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 탑의 개수
		
		Stack<int[]> stack = new Stack<>();
		
		int[] ans = new int[N];//답 넣을 배열

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());;//탑 높이 입력받기
			int[] arr = new int[2];//탑 높이, 탑 번호
			arr[0] = num;
			arr[1] = i+1;
			
			while (!stack.isEmpty() && stack.peek()[0] < num) {
				stack.pop();
			}
			
			if (stack.isEmpty()) {
				ans[i] = 0;
			} else {
				int idx = stack.peek()[1];
				ans[i] = idx;
			}
			stack.add(arr);
		}
		for(int x : ans) System.out.print(x+" ");
	}
}