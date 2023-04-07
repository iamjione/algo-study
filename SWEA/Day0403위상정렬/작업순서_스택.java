package Day0403��������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class �۾�����_���� {

	static int V;
	static ArrayList<Integer>[] adjList;
	static int[] inDegree;
	static boolean[] visited;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int tc=1; tc<=10; tc++) {
			st = new StringTokenizer(br.readLine());
			V =Integer.parseInt(st.nextToken());// ������ ����
			int E =Integer.parseInt(st.nextToken());// ������ ����
			
			adjList = new ArrayList[V+1];
			for(int i=1; i<V+1; i++) adjList[i] = new ArrayList<>();
			
			inDegree = new int[V+1];//���� ���� �迭
			visited = new boolean[V+1];//�湮 ǥ�� �迭
			stack = new Stack<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				adjList[start].add(end);
				inDegree[end]++;
			}
			
			//���������� 0�� ��忡 ���� DFS ����
			for(int i=1; i<V+1; i++) {
				if(inDegree[i]==0) TopologicalSort(i);
			}
			
			//���ÿ� �ִ� �� pop�� ������� ��Ʈ�������� ����
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);
			while(!stack.isEmpty()) {
				sb.append(" ").append(stack.pop());
			}
			
			System.out.println(sb);
			
		}//tc
	}

	private static void TopologicalSort(int v) {
		visited[v] = true;//�湮 ǥ�� ���ֱ�
		
		//���� ���� �� �湮���� ���� �� ������ ��� ȣ��
		for(int u : adjList[v]) {
			if(visited[u]==false) TopologicalSort(u);
		}
		//���ÿ� �־���
		stack.push(v);
	}
}