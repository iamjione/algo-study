import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] result;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		result = new int[M];
		sb = new StringBuilder();
		
		combination(1,0);
		System.out.println(sb);
	}

	private static void combination(int num, int idx) {
		if(idx==M) {//M개 다 뽑은 경우
			for(int x:result) {
				sb.append(x+" ");
			}
			sb.append('\n');
			return;
		}
		
		if(num==N+1) return;
		
		result[idx] = num;
		combination(num+1, idx+1);//조합에 num 포함 && 다음 숫자 판단하러 고고
		combination(num+1, idx);//조합에 num 포함 안함 && 다음 숫자 판단하러 고고
		
	}

}