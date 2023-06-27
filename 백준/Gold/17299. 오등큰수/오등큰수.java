import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] cnt = new int[1000001];//등장횟수 배열

		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<N; i++) {
			//숫자 스택에 저장
			int n = Integer.parseInt(st.nextToken());
			stack.push(n);
			//해당 숫자의 등장 횟수 업데이트
			cnt[n]++;
		}
		
		int[] NGF = new int[N];//오등큰수 저장할 배열
		Arrays.fill(NGF, -1);

		for(int i=N-1; i>0; i--) {
			int curr = stack.pop();
			//curr의 왼쪽에 있는 숫자 중 등장 횟수 적은 값들의 오등큰수 갱신
			//등장횟수 크거나 같은 값 만나면 갱신 멈추기
			for(int j=i-1; j>=0; j--) {
				if(cnt[stack.get(j)]>=cnt[curr]) break;
				NGF[j] = curr;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int ngf:NGF) sb.append(ngf+" "); 
		System.out.println(sb);
		
	}

}