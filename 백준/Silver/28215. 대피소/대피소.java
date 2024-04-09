import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	static int[][] houses;
	static int N, K;
	static int min = Integer.MAX_VALUE; // 답으로 출력할 값
	static Set<Integer> set = new HashSet<>(); // 대피소 K개 저장할 집합
	static int[] mins; // 각 집에서 대피소까지 최소 거리 저장할 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		mins = new int[N];
		
		// 집 위치 저장
		houses = new int[N][2];
		for(int i=0; i<N; i++) {
			houses[i] = new int[]{sc.nextInt(), sc.nextInt()};
		}
		
		// 대피소 K개 선택 후 대피소까지의 최단 거리 중 최대값 구하기
		selectShelter(0, K);
		
		System.out.println(min);
	}

	// 대피소 K개 선택 후 findMaxDistance 실행하는 메서드
	private static void selectShelter(int idx, int k) {
		if(set.size()==k) {
			findMaxDistance();
			return;
		}
		
		if(idx>=N) return;
		
		set.add(idx);
		selectShelter(idx+1, k);
		set.remove(idx);
		selectShelter(idx+1, k);
	}


	// 대피소까지의 최단 거리 구하고 그 중 최대값 찾아서 최대값들 중 최소값인 min 갱신하는 메서드
	private static void findMaxDistance() {
		// 최대값으로 배열 초기화
		Arrays.fill(mins, Integer.MAX_VALUE);
		
		// 대피소까지의 최단 거리 구하기
		for(int idx : set) {
			for(int i=0; i<N; i++) {
				mins[i] = Math.min(mins[i], calculateDistance(i, idx));
			}
		}
		
		// 최단 거리 중 최대값 구하기
		int max = 0;
		for(int n : mins) {
			max = Math.max(max, n);
		}

		// 최대값 중 최소값 구하기
		min = Math.min(min, max);
	}

	// i번째 집과 j번째 집 사이의 거리 계산하는 메서드
	private static int calculateDistance(int i, int j) {
		
		return Math.abs(houses[i][0] - houses[j][0]) + Math.abs(houses[i][1] - houses[j][1]);
	}

}