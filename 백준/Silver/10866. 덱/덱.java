import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Deque<Integer> d = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			String order = sc.next();
			switch (order) {
			case "push_front":
				int x = sc.nextInt();
				d.addFirst(x);
				break;
			case "push_back":
				int y = sc.nextInt();
				d.addLast(y);
				break;
			case "pop_front":
				if (!d.isEmpty())
					sb.append(d.removeFirst()).append('\n');
				else
					sb.append(-1).append('\n');
				break;
			case "pop_back":
				if (!d.isEmpty())
					sb.append(d.removeLast()).append('\n');
				else
					sb.append(-1).append('\n');
				break;
			case "size":
				sb.append(d.size()).append('\n');
				break;
			case "empty":
				if (d.isEmpty())
					sb.append(1).append('\n');
				else
					sb.append(0).append('\n');
				break;
			case "front":
				if (!d.isEmpty())
					sb.append(d.peekFirst()).append('\n');
				else
					sb.append(-1).append('\n');
				break;
			case "back":
				if (!d.isEmpty())
					sb.append(d.peekLast()).append('\n');
				else
					sb.append(-1).append('\n');
			}
		}
		System.out.println(sb);

	}

}