import java.util.Scanner;

public class Main {
	static int N;//배열 크기
	static char[][] arr;//사탕 색 입력받을 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N][N];
		
		//배열에 사탕색 입력받기
		for(int i=0; i<N; i++) {
			arr[i] = sc.next().toCharArray();
		}
		
		//교환 전 가장 긴 연속 부분 카운트
		int ans = maxCandy();
		
		//다른 사탕이 인접해있는 부분 찾아서 교환
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				//양옆의 사탕색 다른 경우
				if(j+1<N && arr[i][j] != arr[i][j+1]) {
					//사탕 자리 바꿨을 때 가장 긴 연속부분이
					//이전의 경우보다 크면 그 값을 ans로 저장
					//자리 다시 원래대로!
					swap(i, j, i, j+1);
					int n = maxCandy();
					if(n>ans) ans = n;
					swap(i, j, i, j+1);
				}
				//위아래 사탕색 다른 경우
				if(i+1<N && arr[i][j] != arr[i+1][j]) {
					swap(i, j, i+1, j);
					int n = maxCandy();
					if(n>ans) ans = n;
					swap(i, j, i+1, j);
				}
			}
		}
		System.out.println(ans);

	}

	//가장 긴 연속부분 카운트하는 함수
	private static int maxCandy() {
		int max = 0;
		
		for(int i=0; i<N; i++) {
			int rCnt = 1;//행 카운트
			int cCnt = 1;//열 카운트
			for(int j=0; j<N-1; j++) {
				//행
				if(arr[i][j]==arr[i][j+1]) {
					rCnt++;
				}else {
					if(rCnt>max) max = rCnt;
					rCnt=1;
				}
				//열
				if(arr[j][i]==arr[j+1][i]) {
					cCnt++;
				}else {
					if(cCnt>max) max = cCnt;
					cCnt = 1;
				}
				
				if(j==N-2) {
					if(rCnt>max) max = rCnt;
					if(cCnt>max) max = cCnt;
				}
			}
		}
		return max;
	}
	
	//arr[i][j]와 arr[k][l]의 값 바꾸는 함수
	private static void swap(int i, int j, int k, int l) {
		char tmp = arr[i][j];
		arr[i][j] = arr[k][l];
		arr[k][l] = tmp;
	}

}