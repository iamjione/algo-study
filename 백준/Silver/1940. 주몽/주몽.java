import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 재료 개수
		int M = sc.nextInt();// 갑옷을 만드는 데 필요한 수

		//N개의 재료 번호 입력받아서 배열에 저장
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
	
		int cnt = 0;//만들 수 있는 갑옷 개수
		
		int i=0, j=1;
		while(i<N-1) {
			//두 수를 더해서 M이 되는 경우
			if(arr[i]+arr[j]==M) {
				cnt++;//갑옷 개수 카운트
				//다음 값 보기
				i++;
				j = i+1;
			
            //두 수를 더해서 M이 되지 않는 경우
			}else {
				//j가 아직 이동할 곳이 남아있다면
				if(j<N-1) j++;//j 한칸 이동
				//j가 배열 끝까지 갔는데 더해서 M이 되는 경우 못찾았다면
				else {
					//다음 값 보기
					i++;
					j = i+1;
				}
			}
		}
		System.out.println(cnt);
	}
}