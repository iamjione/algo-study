import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int[] pi;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//데이터 베이스에 존재하는 노래 수
		StringTokenizer st;
		int[][] db = new int[N][];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());//노래 길이
			db[i] = new int[K-1];
			//데이터 베이스에 존재하는 노래의 앞뒤 음의 차이 배열에 저장
			int n1 = Integer.parseInt(st.nextToken());
			for(int j=0; j<K-1; j++) {
				int n2 = Integer.parseInt(st.nextToken());
				db[i][j] = n1-n2;
				n1 = n2;
			}
		}
		
		int L = Integer.parseInt(br.readLine());//찾으려는 멜로디의 길이
		//찾으려는 멜로디의 앞뒤 음의 차이 배열에 저장
		int[] melody = new int[L-1];
		st = new StringTokenizer(br.readLine());
		int n1 =  Integer.parseInt(st.nextToken());
		for(int i=0; i<L-1; i++) {
			int n2 =  Integer.parseInt(st.nextToken());
			melody[i] = n1-n2;
			n1 = n2;
		}
		
		getPi(melody);//실패 테이블 만들기
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			//kmp 실행해서 같은 멜로디 찾으면 스트링빌더에 노래 번호 저장
			boolean find = kmp(db[i], melody);
			if(find) sb.append(i+1).append(" ");
		}
		
	
		//찾으려는 멜로디가 없을 경우 -1 출력 있으면 노래 번호 출력
		if(sb.length()==0) System.out.println(-1);
		else System.out.println(sb);

	}

	private static boolean kmp(int[] db, int[] melody) {	
		int j = 0;
		
		for(int i=0; i<db.length; i++) {
			while(j>0 && db[i]!=melody[j]) {
				j = pi[j-1];
			}
			if(db[i]==melody[j]) {
				if(j==melody.length-1) {
					j = pi[j];
					return true;
				}else j++;
			}
		}
		return false;
		
	}

	private static void getPi(int[] melody) {
		//접두사와 접미사가 일치하는 최대 길이를 담을 배열
		//0~i까지의 부분 문자열에서 접미사&접두사 일치하는 길이를 담음
		pi = new int[melody.length];
		
		int j = 0;
		for(int i=1; i<melody.length; i++) {
			while(j>0 && melody[i] != melody[j]) {
				j = pi[j-1];
			}
			if(melody[i]==melody[j]) pi[i]=++j;
		}
	}

}