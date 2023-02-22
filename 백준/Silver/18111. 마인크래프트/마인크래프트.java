import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());//인벤토리 블록 개수
		
		int[][] arr = new int[N][M];
		
		int min = 256;//땅 높이 최소값
		int max = 0;//땅 높이 최대값
		
		//배열에 입력받으면서 최소&최대값 구하기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]<min) min = arr[i][j];
				else if(arr[i][j]>max) max = arr[i][j];
			}
		}
		
		//최소값부터 최대값까지 돌면서 어떤 높이에 맞춰야 시간 최소&&땅 높이 최대인지 구하기
		int num = min;//현재 땅 높이
		int ans = 0; //정답으로 출력될 땅 높이
		int time=Integer.MAX_VALUE;//땅고르는데 걸리는 시간 최대값으로 초기화해줌
		
		while(num<=max) {
			int tmpTime = 0;//임시 시간
			int tmpB = B;//임시 인벤토리
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					//num보다 작은 수는 부족한 만큼 인벤토리에서 블록 빼서 더해주기 >>블록당 1초
					if(arr[i][j]<num) {
						tmpTime += (num-arr[i][j]);
						tmpB -= num-arr[i][j];
					//num보다 큰 수는 넘는 만큼 빼서 인벤토리 블록 넣기 >> 블록당 2초
					}else if(arr[i][j]>num) {
						tmpTime += 2*(arr[i][j]-num);
						tmpB += arr[i][j]-num;
					}
				}
			}
			if(tmpB>=0 && tmpTime<=time) {
				time = tmpTime;
				ans = num;
			}
			num++;
		}
		System.out.println(time+" "+ans);
	}
}