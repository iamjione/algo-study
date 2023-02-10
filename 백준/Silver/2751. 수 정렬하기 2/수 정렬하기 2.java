import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> ll = new LinkedList<>();
		
		for(int i = 0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			ll.add(num);
		}

		Collections.sort(ll);
		
		for(int x : ll) {
			sb.append(x).append('\n');
		}
		System.out.println(sb);
	}

}