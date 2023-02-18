import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//사람 수
		
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			for(int j=0; j<2; j++) {
				arr[i][j]=sc.nextInt();
			}
		}//배열에 입력받기

		int[] ans = new int[N];//등수 입력할 배열
		
		//등수 카운트
		for(int i=0; i<N; i++) {
			int cnt = 1;//나보다 덩치큰 사람 k명이면 등수 k+1이므로 cnt 기본값 1로 해줌
			for(int j=0; j<N; j++) {
				if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]) cnt++;
				//키+몸무게 다 나보다 크면 카운트 올려줌
			}
			ans[i]=cnt;
		}
		
		for(int x:ans) System.out.print(x+" ");
	}

}