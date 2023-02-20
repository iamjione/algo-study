import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();

		int back = 0;//back연산 수행시 사용할 큐의 가장 마지막 값
		
		for (int i = 0; i < N; i++) {
			String order = sc.next();
			switch (order) {
			case "push":
				int x = sc.nextInt();
				queue.offer(x);
				back = x;//새로운 값 넣을 때마다 그 값을 큐의 가장 마지막값으로 설정해줌!
				break;
			case "pop":
				if (!queue.isEmpty())
					sb.append(queue.poll()).append('\n');
				else
					sb.append(-1).append('\n');
				break;
			case "size":
				sb.append(queue.size()).append('\n');
				break;
			case "empty":
				if (queue.isEmpty())
					sb.append(1).append('\n');
				else
					sb.append(0).append('\n');
				break;
			case "front":
				if (!queue.isEmpty())
					sb.append(queue.peek()).append('\n');
				else
					sb.append(-1).append('\n');
				break;
			case "back":
				if (!queue.isEmpty())
					sb.append(back).append('\n');
				else
					sb.append(-1).append('\n');
			}
		}
		System.out.println(sb);

	}

}