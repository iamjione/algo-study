import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//스위치개수
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] =sc.nextInt();
		
		int s = sc.nextInt();//학생수
		
		for(int i=0; i<s; i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();
			if(gender==1) {
				for(int j=1;j<=n; j++) {
					if(j%num==0) arr[j-1]=change(arr[j-1]);
				}
			}else if(gender==2){
				arr[num-1]=change(arr[num-1]);
				int range = num-1;
				if(n-num<range) range = n-num;
				for(int j=0; j<range; j++) {
					if(arr[num-2-j]==arr[num+j]) {
						arr[num-2-j]=change(arr[num-2-j]);
						arr[num+j]=change(arr[num+j]);
					}
					else break;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
			if((i+1)%20==0) System.out.println();
		}

	}
	
	private static int change(int a) {
		if(a==0) return 1;
		else return 0;
	}

}