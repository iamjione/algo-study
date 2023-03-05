import java.util.Scanner;

public class Main {
	static int N;//숫자 개수
	static int[] arr;//숫자 입력받을 배열
	static int[] op = new int[4];//연산자 개수 입력받을 배열
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		//배열에 숫자 입력받기
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		//배열에 연산자 개수 입력받기
		//op[0]:더하기 op[1]:빼기 op[2]:곱하기 op[3]:나누기
		for(int i=0; i<4; i++) {
			op[i] = sc.nextInt();
		}
		
		cal(arr[0],1);
		System.out.println(max);
		System.out.println(min);
	}

	//최소값 최대값 계산하는 함수
	private static void cal(int num, int idx) {
		if(idx==N) {
			if(num>max) max = num;
			if(num<min) min = num;
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(op[i]>0) {//연산자가 있으면
				op[i]--;//연산자 사용
				switch(i) {
				case 0:
					cal(num+arr[idx],idx+1);
					break;
				case 1:
					cal(num-arr[idx],idx+1);
					break;
				case 2:
					cal(num*arr[idx],idx+1);
					break;
				case 3:
					cal(num/arr[idx],idx+1);
				}
				op[i]++;//연산자 개수 다시 복구
			}
		}
	}
}