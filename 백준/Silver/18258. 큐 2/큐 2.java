import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Deque<Integer> q = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());//명령 횟수
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			switch(cmd) {
			case "push":
				q.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(!q.isEmpty()) sb.append(q.pop()).append('\n');
				else sb.append(-1).append('\n');
				break;
			case "size":
				sb.append(q.size()).append('\n');
				break;
			case "empty":
				if(q.isEmpty()) sb.append(1).append('\n');
				else sb.append(0).append('\n');
				break;
			case "front":
				if(!q.isEmpty()) sb.append(q.peekFirst()).append('\n');
				else  sb.append(-1).append('\n');
				break;
			case "back":
				if(!q.isEmpty()) sb.append(q.peekLast()).append('\n');
				else  sb.append(-1).append('\n');
			}
		}
		
		System.out.println(sb);
		
	}

}