import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static int N, M, K;
	static int[][] skills;
	static Map<Integer, Integer> keys = new HashMap<>();// 키 번호, 해당 키를 사용하는 퀘스트 수
	static int max = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();// 키의 개수
		M = sc.nextInt();// 퀘스트의 개수
		K = sc.nextInt();// 퀘스트당 사용해야 하는 스킬 수
		
		skills = new int[M][K];
		for(int i=0; i<M; i++) {
			for(int j=0; j<K; j++) {
				skills[i][j] = sc.nextInt();
			}
		}
		
		recur(0, 0);
		
		System.out.println(max);
	}

	private static void recur(int idx, int cnt) {
		if(keys.size()>N) return;
		
		if(idx==M) {
			max = Math.max(max, cnt);
			return;
		}
		
		//idx번째 퀘스트 깨는 경우
		for(int i=0; i<K; i++) {
			keys.put(skills[idx][i], keys.getOrDefault(skills[idx][i], 0)+1);
		}
		
		recur(idx+1, cnt+1);
		
		for(int i=0; i<K; i++) {
			if(keys.get(skills[idx][i])==1) keys.remove(skills[idx][i]);
			else keys.replace(skills[idx][i], keys.get(skills[idx][i])-1);
		}
		
		
		//idx번째 퀘스트 안깨는 경우
		recur(idx+1, cnt);
		
	}

}