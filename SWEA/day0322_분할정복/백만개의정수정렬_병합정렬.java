package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백만개의정수정렬_병합정렬 {

	static int[] A = new int[1000000];
	static int[] tmp = new int[1000000];
	
	public static void main(String[] args) throws IOException {
		//정수 백만개 입력받아서 배열에 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<1000000; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		//병합 정렬
		mergeSort(0,999999);
		System.out.println(A[500000]);
	
	}

	private static void mergeSort(int L, int R) {
		
		if(L>=R) return;
		
		int mid = (L+R)/2;
		mergeSort(L,mid);//왼쪽 분할
		mergeSort(mid+1, R);//오른쪽 분할
		merge(L,mid,R);//정렬하면서 병합
		
	}

	private static void merge(int L, int mid, int R) {
		int left = L;//왼쪽 구역 시작 인덱스
		int right = mid+1;//오른쪽 구역 시작 인덱스
		
		int idx = left;
		
		while(left<=mid && right<=R) {//한쪽 값 다 쓸 때까지 반복
			//left랑 right값 중에 더 작은 값 tmp[idx]에 저장
			if(A[left]<=A[right]) tmp[idx++]=A[left++];
			else tmp[idx++]=A[right++];
		}
		
		//남아있는 애들도 배열에 넣어줌
		if(left<=mid) {//왼쪽 구역에 숫자 남아있는 경우
			for(int i=left; i<=mid; i++) {
				tmp[idx++] = A[i];
			}
		}else {//오른쪽 구역에 숫자 남아있는 경우
			for(int i=right; i<=R; i++) {
				tmp[idx++] = A[i];
			}
		}
		
		//정렬 끝난 tmp배열 원본배열A로 옮겨줌
		for(int i=L; i<=R; i++) {
			A[i] = tmp[i];
		}
	}
}
