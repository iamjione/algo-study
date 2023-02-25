import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 기다리고 있는 사람 수
				
		Stack<int[]> stack = new Stack<>();
		long cnt = 0;// 서로 볼 수 있는 쌍의 수
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			int[] arr = new int[2];
			arr[0]=num;
			arr[1]=1;
			
			if(stack.isEmpty()) {
				stack.add(arr);
			}else {
				int size = stack.size();
				for(int j=size-1; j>=0; j--) {
					if(stack.get(j)[0]==num) {
						arr[1] +=stack.get(j)[1];
						cnt += stack.peek()[1];
						stack.pop();
					}else if(stack.get(j)[0]>num) {
						cnt ++;
						break;
					}else {//stack.get(j)[0]<num
						cnt += stack.peek()[1];
						stack.pop();
					}
				}
				stack.add(arr);
			}
		}
		System.out.println(cnt);
	}
}