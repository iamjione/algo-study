import java.util.Scanner;

public class Main {

	static int n, k;
	static int[] arr = {1, 2, 3};
	static int[] sel;
	static int cnt = 0;
	static boolean end = false;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		sel = new int[n];
		
		makeNumber(0, 0);
		
		if(!end) System.out.println(-1);
	}

	private static void makeNumber(int idx, int sum) {
		
		if(end) return;
		
		if(sum == n) {
			cnt++;
			
			if(cnt==k) {
				print();
				end = true;
			}
			
			return;
		}
		
		
		for(int i=0; i<3; i++) {
			if(sum+arr[i]>n) continue;
			
			sel[idx] = arr[i];
			makeNumber(idx+1, sum+arr[i]);
			sel[idx] = 0;
		}
		
	}

	private static void print() {
		for(int i=0; i<n; i++) {
			System.out.print(sel[i]);
			if(i==n-1 || sel[i+1]==0) break;
			else System.out.print("+");
		}
	}

}