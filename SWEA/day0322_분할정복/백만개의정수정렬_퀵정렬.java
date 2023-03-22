package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백만개의정수정렬_퀵정렬 {

	static int[] A = new int[1000000];
	
	public static void main(String[] args) throws IOException {
		//정수 백만개 입력받아서 배열에 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<1000000; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		//퀵 정렬
		quickSort(0,999999);
		System.out.println(A[500000]);
	
	}

	//퀵정렬
	private static void quickSort(int L, int R) {
		
		if(L>=R) return;
		
		int pivot = partition(L, R);
		quickSort(L, pivot-1);
		quickSort(pivot+1, R);
		
	}

	//Lomuto partition
	private static int partition(int L, int R) {
		int pivot = A[R];
		int i= L-1;
		
		for(int j=L; j<R; j++) {
			if(A[j]<=pivot) {
				i++;
				swap(i,j);
			}
		}
		swap(i+1, R);
		return i+1;
	}

	//A[i]랑 A[j] 교환
	private static void swap(int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
}
