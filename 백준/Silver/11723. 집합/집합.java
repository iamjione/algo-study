import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//연산 개수
		Set<Integer> s = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			String order = sc.next();
			int num;
			switch(order){
			case "add":
				s.add(sc.nextInt());
				break;
			case "remove":
				num = sc.nextInt();
				if(s.contains(num)) s.remove(num);
				break;
			case "check":
				if(s.contains(sc.nextInt())) sb.append(1).append('\n');
				else sb.append(0).append('\n');
				break;
			case "toggle":
				num = sc.nextInt();
				if(s.contains(num)) s.remove(num);
				else s.add(num);
				break;
			case "all":
				s.removeAll(s);
				for(int n=1; n<=20; n++) {
					s.add(n);
				}
				break;
			case "empty":
				s.removeAll(s);
			}
		}
		System.out.println(sb);
	}
}