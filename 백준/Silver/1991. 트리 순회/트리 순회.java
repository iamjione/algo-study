import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static Map<Character, Node> tree = new HashMap<>();
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());;
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			tree.put(st.nextToken().charAt(0), new Node(st.nextToken().charAt(0), st.nextToken().charAt(0)));
		}
		
		sb = new StringBuilder();
		preOrder('A'); // 전위 순회
		System.out.println(sb.toString());
		
		sb = new StringBuilder();
		inOrder('A'); // 중위 순회
		System.out.println(sb.toString());
		
		sb = new StringBuilder();
		postOrder('A'); // 후위 순회
		System.out.println(sb.toString());

	}

	// 전위 순회 (root - left - right)
	private static void preOrder(char node) {
		sb.append(node);
		
		if(tree.get(node).left!='.')  preOrder(tree.get(node).left);
		
		if(tree.get(node).right!='.')  preOrder(tree.get(node).right);
	}

	// 중위 순회 (left - root - right)
	private static void inOrder(char node) {
		if(tree.get(node).left!='.')  inOrder(tree.get(node).left);
		
		sb.append(node);
		
		if(tree.get(node).right!='.')  inOrder(tree.get(node).right);
	}
	
	// 후위 순회 (left - right - root)
	private static void postOrder(char node) {
		if(tree.get(node).left!='.')  postOrder(tree.get(node).left);
		
		if(tree.get(node).right!='.')  postOrder(tree.get(node).right);
		
		sb.append(node);
	}

	static private class Node{
		char left, right;
		
		public Node(char left, char right) {
			this.left = left;
			this.right = right;
		}
	}

}