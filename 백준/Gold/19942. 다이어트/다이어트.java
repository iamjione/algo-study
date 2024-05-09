import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] m = new int[4];
	static int[][] arr;
	static boolean[] visited;
	static int ans = Integer.MAX_VALUE;
	static LinkedList<Integer> list = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 식재료의 개수
		arr = new int[N][5];
		visited = new boolean[N];
		
		for(int i=0; i<4; i++) {
			m[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		recur(0, 0, 0, 0, 0, 0, 0);
		
		if(ans==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
			for(int n : list) {
				System.out.print(n+" ");
			}			
		}
	}

	private static void recur(int idx, int p, int f, int s, int v, int cost, int cnt) {
		if(cost>ans) return;
		
		if(m[0]<=p && m[1]<=f && m[2]<=s && m[3]<=v && ans>cost && cnt!=0) {
			ans = cost;
			list.clear();
			for(int i=0; i<N; i++) {
				if(visited[i]) list.add(i+1);
			}
		}
		
		if(idx==N) return;
		
		
		visited[idx] = true;
		
		recur(idx+1, p + arr[idx][0], f + arr[idx][1], s + arr[idx][2], v + arr[idx][3], cost + arr[idx][4], cnt+1);
		
		visited[idx] = false;
		
		recur(idx+1, p, f, s, v, cost, cnt);
	}
}

// 99% 오답 반례

/*
3
0 0 0 1
0 0 0 1 1
0 0 0 0 0
0 0 0 0 0

output
1
1 2 3

answer
1
1
 */