import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] trees = new int[N];
		for(int i=0; i<N; i++) {
			trees[i] = sc.nextInt();
		}
		
		Arrays.sort(trees);
		
		int s = 0;
		int e = trees[N-1];
		int l = 0;
		int mid;
		long sum;
		
		while(s<=e) {
			mid = (s+e)/2;
			sum = 0; // 자른 나무들의 길이의 합
			
			for(int tree : trees) {
				if(tree>mid) {
					sum += tree-mid;					
				}
			}
			
			if(sum >= M) {
				l = mid;
				s = mid+1;
			}else {
				e = mid-1;
			}
		}
		
		System.out.println(l);
	}

}