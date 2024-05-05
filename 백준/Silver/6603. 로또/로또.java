import java.util.Scanner;

public class Main {
	
	static int k;
	static int[] numbers;
	static int[] sel = new int[6];
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		while(true) {
			k = sc.nextInt();
			if(k==0) break;
			
			numbers = new int[k];
			for(int i=0; i<k; i++) {
				numbers[i] = sc.nextInt();
			}
			
			selectNumbers(0, 0);
			
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}

	private static void selectNumbers(int idx, int start) {
		if(idx==6) {
			for(int i=0; i<6; i++) {
				sb.append(sel[i]+" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=start; i<k; i++) {
			sel[idx] = numbers[i];
			selectNumbers(idx+1, i+1);
		}
	}
}