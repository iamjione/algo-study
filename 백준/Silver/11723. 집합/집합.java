import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		int S = 0;
		int n;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if (str.equals("add")) {
				n = Integer.parseInt(st.nextToken());
				S |= 1<<n;
			} else if(str.equals("check")) {
				n = Integer.parseInt(st.nextToken());
				if((S & (1<<n)) > 0) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if(str.equals("remove")) {
				n = Integer.parseInt(st.nextToken());
				S &= ~(1<<n);
			} else if(str.equals("toggle")) {
				n = Integer.parseInt(st.nextToken());
				S ^= (1<<n);
			} else if(str.equals("all")) {
				S = (1<<21) -1;
			} else if(str.equals("empty")) {
				S = ~((1<<21) -1);
			}
			
		}
		System.out.println(sb);
	}

}