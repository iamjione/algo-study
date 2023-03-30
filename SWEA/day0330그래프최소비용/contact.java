package day0330그래프최소비용;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class contact {
	
	static List<Integer>[] adjList; //인접리스트
	static int[] visited; //방문 순서 표시할 배열
	static int last;//마지막 방문 순서

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int tc=1; tc<=10; tc++) {
			 int N = sc.nextInt();//입력받는 데이터의 길이
			 int start = sc.nextInt();//시작점
			 
			 visited = new int[101];
			 
			 adjList = new ArrayList[101];
			 for(int i = 1 ; i<101; i++) adjList[i] = new ArrayList<>();
			
			 for(int i=0; i<N/2; i++) {
				 int s = sc.nextInt();
				 int e = sc.nextInt();
				 
				 adjList[s].add(e);
			 }
			 
			 contact(start);
			 
			 int max = 0;
			 for(int i=1; i<101; i++) {
				 if(visited[i]==last && i>max) max = i;				 
			 }
							
			 System.out.println("#"+tc+" "+max);
		}//tc
	}

	private static void contact(int start) {
		Queue<Integer> q = new ArrayDeque();
		
		q.add(start);//출발점 큐에 넣어줌
		visited[start] = 1;
		
		int current;
		while(!q.isEmpty()) {
			current = q.poll();
			
			for(int n : adjList[current]) {
				if(visited[n]==0) {//아직 방문하지 않았으면
					q.add(n);
					visited[n] = last = visited[current]+1;//방문 순서 저장
				}
				
			}
		}
		
	}

}
