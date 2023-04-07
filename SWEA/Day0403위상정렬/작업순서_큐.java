package Day0403��������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class �۾�����_ť {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int tc=1; tc<=10; tc++) {
			st = new StringTokenizer(br.readLine());
			int V =Integer.parseInt(st.nextToken());// ������ ����
			int E =Integer.parseInt(st.nextToken());// ������ ����
			
			ArrayList<Integer>[] adjList = new ArrayList[V+1];
			for(int i=1; i<V+1; i++) adjList[i] = new ArrayList<>();
			
			int[] inDegree = new int[V+1];//���� ���� �迭
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				adjList[start].add(end);
				inDegree[end]++;
			}
			
			Queue<Integer> q = new ArrayDeque<>();
			
			//���������� 0�� ���� ť�� �־���
			for(int i=1; i<V+1; i++) {
				if(inDegree[i]==0) q.add(i);
			}
			
			//�� ������ ��Ʈ�� ����
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);
			
			while(!q.isEmpty()) {
				//ť���� ���� �ϳ� ������ & ��Ʈ�������� �ش� ���� �߰�
				int curr = q.poll();
				sb.append(" ").append(curr);
				
				for(int n : adjList[curr]) {
					//���� ������ ���� ���� 1�� ����
					inDegree[n]--;					
					//���� ������ 0�� �ƴٸ� ť�� ����
					if(inDegree[n]==0) {
						q.add(n);
					}
				}
			}
			System.out.println(sb);
		}//tc
	}
}