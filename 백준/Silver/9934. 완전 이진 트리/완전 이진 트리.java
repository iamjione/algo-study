import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int K, size;
	static int[] arr;
	static List<Integer>[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());//깊이
		
		//방문한 빌딩 번호 방문순서순으로 입력받아서 배열에 저장
		size = (int)Math.pow(2, K)-1;//배열 크기
		arr = new int[size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		tree = new ArrayList[K];
		for(int i=0; i<K; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		LVRtoTree(0,0,size-1);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<K; i++) {
			for(int n : tree[i]) {
				sb.append(n).append(" ");
			}
			sb.append('\n');
		}
		
		System.out.println(sb);

	}

	//중위순회한 결과를 다시 트리로 만들기
	private static void LVRtoTree(int depth,int start,int end) {

		if(start>end) return;//범위의 시작값이 끝값보다 커지면 return
		
		if(depth == K) return;//깊이를 끝까지 다 탐색했으면 return
		
		//start부터 end까지의 범위의 중앙값을 tree[level]에 저장
		int mid = (end+start)/2;
		tree[depth].add(arr[mid]);
		
		//중앙값 기준 왼쪽 범위에 대해 재귀함수 호출
		LVRtoTree(depth+1, start, mid-1);

		//중앙값 기준 오른쪽 범위에 대해 재귀함수 호출
		LVRtoTree(depth+1, mid+1, end);
			
		
	}

}