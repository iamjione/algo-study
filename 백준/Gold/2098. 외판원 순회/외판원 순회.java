import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] cost, dp;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());// 도시의 수
		cost = new int[N][N];// 도시 이동 비용
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N][(1 << N)];// [현재 방문한 도시][지금까지 방문한 도시]
		for (int i = 0; i < N; i++)
			Arrays.fill(dp[i], Integer.MAX_VALUE);

		dp[0][1] = 0;// 0번 마을부터 출발
		TSP(0, 1);// 외판원 순회 시작

		System.out.println(min);
	}

	private static void TSP(int curr, int visited) {
		// 모든 마을을 방문한 경우
		if (visited == ((1 << N) - 1)) {
			if (cost[curr][0] == 0) return;//0번 마을로 못돌아가면 return
			min = Math.min(min, dp[curr][visited] + cost[curr][0]);//최소비용 갱신
			return;
		}

		for (int i = 0; i < N; i++) {
			int next = (1 << i);
			//이미 방문한 경우 컨티뉴
			if ((visited | next) == visited) continue;
			//현재 마을에서 갈 수 없는 경우 컨티뉴
			if (cost[curr][i] == 0) continue;
			//최소비용 갱신
			if (dp[curr][visited] + cost[curr][i] < dp[i][visited | next]) {
				dp[i][visited | next] = dp[curr][visited] + cost[curr][i];
				TSP(i, visited | next);
			}
		}
	}

}