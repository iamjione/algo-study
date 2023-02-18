import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		
		Stack<Integer> st = new Stack<>();
		
		for(int i=0; i<K; i++) {
			int n = sc.nextInt();
			if(n != 0) st.add(n);//n이 0이 아니면 스택에 추가
			else st.pop();//n이 0이면 마지막 값 제거
		}
		
		int sum = 0;
		for(int x:st) sum += x;
		
		System.out.println(sum);
    }
}