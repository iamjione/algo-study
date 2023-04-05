import java.util.Scanner;

public class Main {

	static int N,M;
	static boolean[] visited;
	static int[] result;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//자연수 1부터 N까지
		M = sc.nextInt();//중복 없이 M개 고르기
		
		visited = new boolean[N+1];
		result = new int[M];
		sb = new StringBuilder();
		perm(0);
		System.out.println(sb);
	}

	private static void perm(int idx) {
		//M개 다 골랐으면 스트링 빌더에 답 저장하고 재귀 종료
		if(idx==M) {
			for(int x:result) sb.append(x+" ");
			
			sb.append('\n');
			return;
		}
		
		for(int i=1; i<N+1; i++) {
			//사용한 숫자면 컨티뉴
			if(visited[i]) continue;
			
			//사용하지 않은 숫자면 사용하기
			result[idx] = i;//결과 배열에 넣어주고
			visited[i] = true;//방문 체크
			perm(idx+1);//다음 숫자 선택하러 고고
			visited[i] = false;//방문 체크 원상복구
		}
		
	}

}