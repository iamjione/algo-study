import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 가로
		int M = sc.nextInt(); // 세로
		int L = sc.nextInt(); // 트램펄린 길이
		int K = sc.nextInt(); // 별똥별 수
		
		int[][] stars = new int[K][2]; // 별똥별 떨어지는 위치
		Set<Integer> row = new HashSet<>();
		Set<Integer> col = new HashSet<>();
		
		for(int i=0; i<K; i++) {
			stars[i][0] = sc.nextInt();
			stars[i][1] = sc.nextInt();
			
			row.add(stars[i][0]);
			col.add(stars[i][1]);
		}
		
		int cnt; // 튕겨낸 별똥별 수
		int max = 0; // 튕겨낸 별똥별 수의 최대값
		for(int r : row) {
			for(int c : col) {
				cnt = 0;
				
				// r,c를 시작점으로 트램펄린 설치했을 때 튕겨낼 수 있는 별똥별 수 카운트
				for(int[] star : stars) {
					if(r<=star[0] && r+L>=star[0] && c<=star[1] && c+L>=star[1]) cnt++;
				}
				
				max = Math.max(max,  cnt);
			}
		}
		
		System.out.println(K-max);
	}

}