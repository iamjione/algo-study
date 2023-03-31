import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();
		int n = 0;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String x = st.nextToken();
			if(x.equals("push")) {
				n = Integer.parseInt(st.nextToken());
				q.add(n);
			} else if (x.equals("empty")) {
				if (!q.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(1).append("\n");
				}
			} else if (!q.isEmpty()) {
				if(x.equals("size")) {
					sb.append(q.size()).append("\n");
				} else if(x.equals("pop")) {
					sb.append(q.poll()).append("\n");
				} else if(x.equals("front")) {
					sb.append(q.peek()).append("\n");
				} else if(x.equals("back")) {
					sb.append(n).append("\n");
				}
				
			} else if(q.isEmpty()) {
				if(x.equals("size")) {
					sb.append(q.size()).append("\n");
				} else if(x.equals("pop")) {
					sb.append(-1).append("\n");
				} else if(x.equals("front")) {
					sb.append(-1).append("\n");
				} else if(x.equals("back")) {
					sb.append(-1).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
			}
	
		}
		
		System.out.println(sb);

	}//main

}//class