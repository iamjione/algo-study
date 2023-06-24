import java.util.*;

public class Main {

	static int[] p;
	static int N, cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//노드 개수
		
		//0~N-1번까지 각 노드의 부모 입력받아서 배열에 저장
		p = new int[N];
		for(int i=0; i<N; i++) p[i] = sc.nextInt();
		
		int M = sc.nextInt();//지울 노드 번호
		
		removeNode(M);
		countLeafNode();
		
		System.out.println(cnt);
	}

	private static void removeNode(int n) {
		p[n] = -2;//삭제된 노드 부모 -2로 변경
		
		for(int i=0; i<N; i++) {
            //삭제한 노드의 자식 노드 삭제
			if(p[i]==n) removeNode(i);
		}
		
	}

	private static void countLeafNode() {
		for(int i=0; i<N; i++) {
			//삭제되지 않았고 자식 없으면 리프노드
			if(p[i]!=-2 && !haschild(i)) cnt++;
		}
	}
	
	private static boolean haschild(int n) {
		for(int i=0; i<N; i++) {
			if(p[i]==n) return true;
		}
		return false;
	}
}