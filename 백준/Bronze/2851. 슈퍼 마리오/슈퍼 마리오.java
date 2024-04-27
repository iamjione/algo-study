import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[10];
		arr[0] = sc.nextInt();
		
		for(int i=1; i<10; i++) {
			arr[i] = arr[i-1]+sc.nextInt();
			
			if(arr[i]>=100) {
				if(100-arr[i-1]<arr[i]-100) System.out.println(arr[i-1]);
				else System.out.println(arr[i]);
				
				return;
			}
		}
		System.out.println(arr[9]);
		
		
	}

}