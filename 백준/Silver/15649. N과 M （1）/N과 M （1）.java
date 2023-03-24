import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[] nums;
	static int[] result;
	static boolean[] selected;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[N];
		selected = new boolean[N];
		int num = 1;
		for (int i = 0; i < N; i++) {
			nums[i] = num++;
		}
		result = new int[M]; // 순열 결과를 넣을 배열

		perm(0);

	} // main

	static void perm(int idx) {

		// M개의 선택을 마친 경우 그만.
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			} // for
			System.out.println();
			return;
		} // if

		for (int i = 0; i < N; i++) {
			if (selected[i])
				continue;
			result[idx] = nums[i];
			selected[i] = true; 
			perm(idx + 1); 
			selected[i] = false; 
		}

	}
}// class