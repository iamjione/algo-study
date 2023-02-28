import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//전체 사이트, 비밀번호 개수
		int M = Integer.parseInt(st.nextToken());//비밀번호 찾으려는 사이트 개수
		
		Map<String, String> map = new HashMap<>();//key: 웹사이트, value: 비밀번호
		
		for(int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			String website = st2.nextToken(); //웹사이트
			String pw = st2.nextToken(); //비밀번호
			map.put(website, pw);
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=0; i<M; i++) {
			bw.write(map.get(br.readLine())+'\n');
		}
		bw.flush();
		br.close();
		bw.close();
	}
}