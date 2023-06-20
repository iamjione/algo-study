import java.util.Scanner;

public class Main {

	static int[] inorder, postorder, idx;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//정점 개수
		
		inorder = new int[n];//중위 순회(LVR)
		postorder = new int[n];//후위 순회(LRV)
		idx = new int[n+1];
		
		for(int i=0; i<n; i++) inorder[i] = sc.nextInt();
		for(int i=0; i<n; i++) postorder[i] = sc.nextInt();
		for(int i=0; i<n; i++) idx[inorder[i]] = i;//중위순회값들의 인덱스
		
		preorderTraverse(0,n-1,0,n-1);
		System.out.println(sb);
	}

	private static void preorderTraverse(int inL, int inR, int postL, int postR) {
		if(inL>inR || postL>postR) return;
		
		int root = postorder[postR];//후위순회 결과의 제일 마지막 값이 루트
		sb.append(root+" ");
		
		int rootIdx = idx[root];//루트의 인덱스
		
		//왼쪽 자식에 대해 전위 순회
		preorderTraverse(inL, rootIdx-1, postL, postL+rootIdx-inL-1);
		//오른쪽 자식에 대해 전위 순회
		preorderTraverse(rootIdx+1, inR, postL+rootIdx-inL, postR-1);
		
	}

}