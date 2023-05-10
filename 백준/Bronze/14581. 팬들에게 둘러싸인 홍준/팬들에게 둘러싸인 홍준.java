import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		StringBuilder sb = new StringBuilder();
		sb.append(":fan::fan::fan:"+'\n');
		sb.append(":fan::"+id+"::fan:"+'\n');
		sb.append(":fan::fan::fan:");
		System.out.println(sb);
	}
}