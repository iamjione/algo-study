package day0228_Tree;

import java.util.Scanner;

public class 중위순회 {
	static int N;//정점 총 개수
	static int[][] arr;//정점 번호 인덱스로 자식 정점 번호 저장할 배열
	static String[] letter;//정점 번호 인덱스로 해당 정점의 문자 입력할 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			N = sc.nextInt();//정점 총 개수
			sc.nextLine();//개행 처리
			arr = new int[N+1][2];
			letter = new String[N+1];
			
			//트리 정보 입력 받기
			for(int i=1; i<=N; i++) {
				//한 줄 입력 받아서 공백 기준으로 split해서 배열에 넣음
				String s = sc.nextLine();
				String[] arrS = s.split(" ");
				//문자 letter 배열에 저장
				letter[i] = arrS[1];
				//자식이 있으면 자식 정점 번호 배열에 저장
				switch(arrS.length) {
				case 4://오른쪽 자식 있으면 오른쪽 자식, 왼쪽 자식 배열에 저장
					arr[i][1] = Integer.parseInt(arrS[3]);
				case 3://왼쪽 자식만 있으면 왼쪽 자식 배열에 저장
					arr[i][0] = Integer.parseInt(arrS[2]);
				}
			}
			
			System.out.print("#"+tc+" ");
			inOrderTraversal(1);
			System.out.println();
		}
	}
	
	//중위 순회(LVR)
	public static void inOrderTraversal(int num) {
        //L
	if(arr[num][0]!=0) inOrderTraversal(arr[num][0]);
	//V
        System.out.print(letter[num]);
        //R
        if(arr[num][1]!=0) inOrderTraversal(arr[num][1]);
        
	}

}
