import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();//낮에 올라 갈 수 있는 높이
		int B = sc.nextInt();//밤에 미끄러지는 높이
		int V = sc.nextInt();//올라가려는 나무막대 높이
		
		int day = 0; //며칠 걸리는지
		
		if(A>V) day=1;
		else if((V-A)%(A-B)==0) day = (V-A)/(A-B)+1;
		else day = (V-A)/(A-B)+2;
		
		System.out.println(day);
	}

}