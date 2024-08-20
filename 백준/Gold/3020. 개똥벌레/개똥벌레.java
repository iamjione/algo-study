import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 동굴 길이
		int H = sc.nextInt(); // 동굴 높이
		
		int[] imos = new int[H+1];
		int size;
		for(int i=1; i<=N; i++) {
			size = sc.nextInt();
			if(i%2==0) {// 종유석
				imos[H-size+1]++;
			}else { // 석순
				imos[1]++;
				imos[size+1]--;
			}
		}
		
		
		int[] prefix_sum = new int[H+1]; // imos의 누적합 == 각 구간에서 파괴해야하는 장애물 수
		for(int i=1; i<=H; i++) {
			prefix_sum[i] = prefix_sum[i-1]+imos[i];
		}
		
		int min = Integer.MAX_VALUE; // 파괴해야하는 장애물의 최솟값
		int cnt = 0; // 파괴해야하는 장애물이 최소인 구간의 수
		for(int i=1; i<=H; i++) {
			if(min>prefix_sum[i]) {
				min = prefix_sum[i];
				cnt = 1;
			}else if(min==prefix_sum[i]) {
				cnt++;
			}
		}
		
		System.out.println(min+" "+cnt);

	}

}