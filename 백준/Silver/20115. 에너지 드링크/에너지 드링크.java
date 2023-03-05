import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int N = sc.nextInt();//에너지 드링크 개수
		
		//배열에 입력받기
		double[] arr = new double[N];
		for(int i=0; i<N; i++) {
			arr[i]= sc.nextDouble();
		}
		
		//정렬
		Arrays.sort(arr);
		
		double ans = arr[N-1];//최대값은 그냥 있고
		//다른 값들 나누기2해서 최대값에 더해줌
		for(int i=N-2; i>=0; i--) {
			ans += arr[i]/2;
		}
		
		//소수점 이하 값 없으면 그냥 정수로 출력
		//아니면 그냥 double형으로 출력
		if(ans==(int)ans) System.out.println((int)ans);
		else System.out.println(ans);
		
	}
}