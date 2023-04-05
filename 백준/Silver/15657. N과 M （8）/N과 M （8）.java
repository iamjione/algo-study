import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] arr, result;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		result = new int[M+1];
		sb = new StringBuilder();
		
		perm(1);
		System.out.println(sb);

	}

	private static void perm(int idx) {
		//M개 다 골랐으면 스트링 빌더에 답 저장하고 재귀 종료
		if(idx==M+1) {
			for(int i=1; i<=M; i++) {
				sb.append(result[i]+" ");
			}
			sb.append('\n');
			return;
		}
				
		for(int i=0; i<N; i++) {
			if(arr[i]>=result[idx-1]) {//이전에 선택한 숫자보다 크거나 같으면
				result[idx] = arr[i];//결과 배열에 넣어주고
				perm(idx+1);//다음 숫자 선택하러 고고		
			}
		}
	}

}