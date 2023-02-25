import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr= new int[41][2];
		arr[0][0] = 1;
		arr[1][1] = 1;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			for(int j=2; j<=num; j++) {
				arr[j][0] = arr[j-1][0] + arr[j-2][0];
				arr[j][1] = arr[j-1][1] + arr[j-2][1];	
			}
			System.out.print(arr[num][0]+" ");
			System.out.print(arr[num][1]+"\n");
		}
	}
}