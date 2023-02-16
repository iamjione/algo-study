import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int[] arr = new int[3];
			for(int i=0; i<3; i++) {
				arr[i]=sc.nextInt();
			}//배열에 숫자 3개 입력받기
			
			if(arr[0]+arr[1]+arr[2]==0) {
				break;//숫자 3개 다  0이면 멈춤
			}else{
				//정렬 후 피타고라스 정리 해주기
				Arrays.sort(arr);
				if(arr[2]*arr[2]==arr[0]*arr[0]+arr[1]*arr[1]) 
					System.out.println("right");
				else System.out.println("wrong");
			}
		}
	}
}