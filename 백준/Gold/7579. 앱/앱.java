import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//앱 개수
		int M = sc.nextInt();//필요한 메모리
		
		int[] memory = new int[N];
		int[] cost = new int[N];
		for(int i=0; i<N; i++) memory[i] = sc.nextInt();//사용중인 메모리
		for(int i=0; i<N; i++) cost[i] = sc.nextInt();//비활성화 비용
		
		int[] dp = new int[10001];//idx만큼의 비용으로 확보할 수 있는 최대 메모리(앱 개수 최대 100, 비용 최대100 => 총 최대 비용 10000)
		int min = Integer.MAX_VALUE;//답으로 출력할 최소 비용 최대값으로 초기화
		
		for (int i = 0; i < N; i++) {
            for (int j = 10000; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j-cost[i]] + memory[i], dp[j]);
                //M바이트 이상의 메모리 확보할 수 있고 min보다 비용이 적다면 min 갱신
                if(dp[j]>=M && j<min) min = j;
            }
        }
		System.out.println(min);
	}

}