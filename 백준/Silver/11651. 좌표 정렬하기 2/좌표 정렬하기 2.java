import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
        
		//배열에 입력받기
		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}

		// 정렬
		Arrays.sort(arr, new Comparator<int[]>() {
			/*compare의 리턴값 양수일 경우에 두 값 바꿔줌
			1. y좌표 값 비교해서 두 값이 다르면 y좌표 기준으로 정렬
			2. y좌표 값 같으면 x좌표 기준으로 정렬 */
			@Override
			public int compare(int[] o1, int[] o2) {
				int result = o1[1]-o2[1];
				if(result != 0) return result;
				else return o1[0]-o2[0];
			}
		});

		for(int i=0; i<N; i++) {
			System.out.println(arr[i][0]+" "+arr[i][1]);
		}
	}

}