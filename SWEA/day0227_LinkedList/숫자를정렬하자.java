package day0227_LinkedList;

import java.util.Scanner;
//삽입정렬
public class 숫자를정렬하자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//테스트케이스
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();//숫자 개수
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}//배열에 숫자 입력 받음
			
			//삽입정렬
			for(int i=1; i<N; i++) {
				int idx = i;//삽입할 위치
				for(int j=i-1; j>=0; j--) {
					if(arr[i]<arr[j]) {//arr[i]보다 작은 수가 앞에 있는 경우
						idx = j;
					}else {//arr[i]보다 arr[j]가 작거나 같으면 그보다 앞부분은 볼 필요 없음
						break;
					}
				}
				//앞부분에 삽입
				if(idx != i) {
					int tmp = arr[i];//arr[i]값 임시 변수에 넣어줌
					//인덱스 j~i-1까지의 값 j+1~i까지로 이동
					while(i>idx) {
						arr[i] = arr[i-1];
						i--;
					}
					arr[idx] = tmp;//임시 변수에 넣어둔arr[i]값을 arr[idx]에 삽입
				}
				
			}
			System.out.print("#"+tc);
			for(int x:arr) System.out.print(" "+x);
			System.out.println();
		}

	}

}
