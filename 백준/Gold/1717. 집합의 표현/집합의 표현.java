import java.util.Scanner;

public class Main {
	
	static int[] arr;

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		arr = new int[N+1];
		for(int i = 0; i<N+1; i++) {
			arr[i] = i;
		}
		
		
		for(int i=0; i<M; i++) {
			int part = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(part == 0) {
				arr[find(b)] = find(a);
			} else {
				if(find(a) == find(b)) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
			}
		}
		
		System.out.println(sb);
		
		
	} // main

	private static int find(int x) {
		if(x != arr[x]) 
			arr[x] = find(arr[x]);
		return arr[x];
	}
	


}//class