import java.util.Scanner;

public class Main {

	static int k;
	static char[] arr;
	static int[] num;
	static boolean[] visited;
	static boolean end;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		k = sc.nextInt();
		
		arr = new char[k];
		for(int i=0; i<k; i++) {
			arr[i] = sc.next().charAt(0);
		}
		
		init();
		findMax(0);
		
		init();
		findMin(0);
	}
	
	private static void init() {
		visited = new boolean[10];
		num = new int[k+1];
		end = false;
	}

	private static void findMax(int idx) {
		if(end) return;
		
		if(idx==k+1) {
			print();
			end = true;
			return;
		}
		
		for(int i=9; i>=0; i--) {
			if(visited[i] || !valid(i, idx)) continue;
			
			num[idx] = i;
			visited[i] = true;
			findMax(idx+1);
			visited[i] = false;
		}
		
	}

	private static void findMin(int idx) {
		if(end) return;
		
		if(idx==k+1) {
			print();
			end = true;
			return;
		}
		
		for(int i=0; i<=9; i++) {
			if(visited[i] || !valid(i, idx)) continue;
			
			num[idx] = i;
			visited[i] = true;
			findMin(idx+1);
			visited[i] = false;
		}
		
	}

	private static boolean valid(int i, int idx) {
		
		if(idx==0) {
			if(arr[idx]=='<' && i!=9) return true;
			else if(arr[idx]=='>' && i!=0) return true;
		}else {
			if(arr[idx-1]=='<') {
				if(num[idx-1]<i) return true;
			}else {
				if(num[idx-1]>i) return true;
			}
		}
		
		return false;
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<k+1; i++) {
			sb.append(num[i]);
		}
		System.out.println(sb.toString());
	}

}