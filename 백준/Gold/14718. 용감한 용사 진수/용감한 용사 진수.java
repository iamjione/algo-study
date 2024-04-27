import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 총 병사 수
		int K = sc.nextInt(); // 진수가 이겨야할 병사 수
		
		int[][] stats = new int[N][3];
		Set<Integer> power = new HashSet<>();
		Set<Integer> agility = new HashSet<>();
		Set<Integer> inteligence = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			stats[i][0] = sc.nextInt();
			stats[i][1] = sc.nextInt();
			stats[i][2] = sc.nextInt();
			
			power.add(stats[i][0]);
			agility.add(stats[i][1]);
			inteligence.add(stats[i][2]);
		}
		
		int cnt;
		int min = Integer.MAX_VALUE;
		for(int p : power) {
			for(int a : agility) {
				for(int i : inteligence) {
					cnt = 0;
					for(int[] stat : stats ) {
						if(stat[0]<=p && stat[1]<=a && stat[2]<=i) cnt++;
					}
					if(cnt>=K) min = Math.min(min, p+a+i);
				}
			}
		}
		
		System.out.println(min);
	}

}