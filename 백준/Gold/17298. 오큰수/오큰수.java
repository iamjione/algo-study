import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//수열의 크기
		
		Stack<int[]> stack = new Stack<>();//{숫자, 인덱스}
		int[] arr = new int[N];//오큰수 저장할 배열

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(stack.isEmpty()) stack.push(new int[] {num, i});
			else {
				while(!stack.isEmpty() && stack.peek()[0]<num) {
					arr[stack.pop()[1]] = num;					
				}
				stack.push(new int[] {num, i});
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			if(arr[i]==0) arr[i]=-1;
			sb.append(arr[i]+" ");
		}
		System.out.println(sb);
	}

}