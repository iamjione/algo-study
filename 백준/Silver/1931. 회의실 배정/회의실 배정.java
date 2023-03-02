import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt();//시작 시간
			arr[i][1] = sc.nextInt();//종료 시간
		}
		
		//종료시간 기준 정렬 && 종료시간 같으면 시작시간 기준 정렬
		Arrays.sort(arr, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) return o1[0]-o2[0];
				
				return o1[1]-o2[1];
			}		
		});
		
		int end = arr[0][1];//첫번째 회의 종료시간
		int cnt = 1;//첫번째 회의 카운트
		
		for(int i=1; i<N; i++) {
			//이전 회의 종료시간보다 다음 회의 시작시간이 느리면 카운트해주고
			//end에 새로운 종료시간 저장
			if(arr[i][0]>=end) {
				cnt++;
				end = arr[i][1];
			}
		}
		
		System.out.println(cnt);
	}

}