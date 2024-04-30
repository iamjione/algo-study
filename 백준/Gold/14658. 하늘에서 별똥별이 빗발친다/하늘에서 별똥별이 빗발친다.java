import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] stars = new int[K][2];
		Set<Integer> setX = new HashSet<>();
		Set<Integer> setY = new HashSet<>();

		for (int i=0; i<K; i++) {
			stars[i][0] = sc.nextInt();
			stars[i][1] = sc.nextInt();
			setX.add(stars[i][0]);
			setY.add(stars[i][1]);
		}
		
		int cnt; //트램펄린이 튕겨낸 별똥별 수
		int max = 0; // cnt의 최대값
		
		// (x,y)에 트램펄린 설치해보기
		for(int x: setX) {
			for(int y : setY) {
				cnt = 0;
				// 범위에 들어오는 별똥별 개수 카운트
				for(int[] star : stars) {
					if(star[0]>=x && star[0]<=x+L && star[1]>=y && star[1]<=y+L) cnt++;
				}
				//최대값 갱신
				max = Math.max(max, cnt);			
			}
		}
		
		System.out.println(K-max);
		
	}

}