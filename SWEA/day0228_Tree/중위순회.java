package day0228_Tree;

import java.util.Scanner;

public class 중위순회 {
	static int N;//정점 총 개수
	static int[][] arr;//노드 번호 인덱스로 자식 노드 저장할 배열
	static String[] letter;//노드 번호 인덱스로 해당 정점의 문자 입력할 배열
	static String[] ans;//답 입력할 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			N = sc.nextInt();//정점 총 개수
			arr = new int[N+1][2];
			letter = new String[N+1];
			ans = new String[N];
			
			for(int i=1; i<=N; i++) {
				String s = sc.nextLine();//한 줄 입력 받기
				letter[i] = s.substring(2, 3);//문자만 분리해서 letter에 넣어주기
				if(s.length()>3) {//왼쪽자식있으면 arr에 왼쪽 자식 저장
					arr[i][0] = Integer.parseInt(s.substring(4, 5));
				}
				if(s.length()>5) {//오른쪽자식있으면 arr에 오른쪽 자식 저장
					arr[i][1] = Integer.parseInt(s.substring(6));
				}
			}
			inOrderTraversal(N);
			System.out.println("#"+" ");
			for(int i=0; i<N; i++) {
				System.out.print(ans[i]);
			}
			System.out.println();
		}//tc
	}
	
	static int i = 0;//ans배열의 인덱스
	public static void inOrderTraversal(int N) {
		//중위 순회: LVR
        if(arr[N][0]!=0) {
        	inOrderTraversal(arr[N][0]);
        }
        ans[i++] = letter[N];
        if(arr[N][1]!=0) {
        	inOrderTraversal(arr[N][1]);
        }
	}

}
