import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); // 양이 먹는 사료 양
		int b = sc.nextInt(); // 염소가 먹는 사료 양
		int n = sc.nextInt(); // 양+염소 마리수
		int w = sc.nextInt(); // 양+염소가 먹은 사료 양
		
		int sheep = 0;
		int goat = 0;
		
		boolean duplicate = false;
		for(int i=1; i<=1000; i++) {
			for(int j=1; j<=1000; j++) {
				if(i+j==n && a*i+b*j==w) {
					if(sheep!=0) {
						duplicate = true;
						break;
					}else {
						sheep = i;
						goat = j;
					}
				}
			}
			if(duplicate) break;
		}
		
		if(duplicate || sheep==0) { // 해가 중복되거나 없는 경우
			System.out.println(-1);
		}else {
			System.out.println(sheep+" "+goat);			
		}
	}

}