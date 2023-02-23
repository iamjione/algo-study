import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		//카운팅 정렬
		int[] cnt = new int[10001];
		//카운팅 배열에 해당 인덱스 숫자 몇번 나오는지 표시
		for(int i=0; i<N; i++) {
			cnt[Integer.parseInt(br.readLine())]++;
		}
		
		//카운팅배열 1-10000까지 돌면서 cnt[i]번동안 i를 StringBuilder에 넣어줌
		//출력할 때 한줄씩 출력해야하니까 '\n'도 넣어주기
		for(int i=1; i<10001; i++) {
			while(cnt[i]>0) { 
				sb.append(i).append('\n');
				cnt[i]--;
			}
		}

		System.out.println(sb);
	}

}