import java.util.Scanner;

public class Main {
	
	static int[] arr, path;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 정수 N

		arr = new int[N+1];//연산 횟수 저장할 배열
		path = new int[N+1];//연산 경로 저장할 배열
		
		for (int i=2; i<N+1; i++) {
			//일단 1빼는 경우 연산 횟수와 경로 배열에 저장
			saveCnt(i, i-1);
			savePath(i, i-1);
			//6의 배수인 경우 -1 /2 /3 비교해서 연산 횟수 최소인 경우 연산횟수와 경로 배열에 저장
			if (i % 6 == 0) {
				if (arr[i] > arr[i/2]+1) {
					saveCnt(i,i/2);
					savePath(i, i/2);
				}
				if (arr[i] > arr[i/3]+1) {
					saveCnt(i,i/3);
					savePath(i, i/3);
				}
			//2의 배수인 경우 -1 /2 비교해서 연산 횟수 최소인 경우 연산횟수와 경로 배열에 저장
			} else if (i % 2 == 0) {
				if (arr[i] > arr[i/2]+1) {
					saveCnt(i,i/2);
					savePath(i, i/2);
				}
			//3의 배수인 경우 -1 /3 비교해서 연산 횟수 최소인 경우 연산횟수와 경로 배열에 저장
			} else if (i % 3 == 0) {
				if (arr[i] > arr[i/3]+1) {
					saveCnt(i,i/3);
					savePath(i,i/3);
				}
			}
		}
		System.out.println(arr[N]);
		StringBuilder sb = new StringBuilder();
		sb.append(N).append(" ");
		while(N>1) {
			sb.append(path[N]).append(" ");
			N = path[N];
		}
		System.out.println(sb);

	}
	
	//arr배열에 연산 횟수 저장하는 메서드
	private static int saveCnt(int i, int j) {
		return arr[i] = arr[j]+1;
	}
	
	//path배열에 경로 저장하는 메서드
	private static int savePath(int i, int n) {
		return path[i] = n;
	}

}