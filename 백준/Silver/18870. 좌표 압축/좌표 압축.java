import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//좌표개수
		
		int[] arr = new int[N];//좌표 입력받을 배열
		TreeSet<Integer> set = new TreeSet<>();//중복 제거&정렬용 TreeSet
		
		//숫자 입력받아서 배열에 저장 & set에 추가
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			set.add(arr[i]);
		}
		
		//key: 숫자, value: Key보다 작은 숫자의 개수
		HashMap<Integer, Integer> map = new HashMap<>();
		int order = 0;
		for(int n : set) map.put(n, order++);
		
		//출력
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		System.out.println(sb);

	}

}