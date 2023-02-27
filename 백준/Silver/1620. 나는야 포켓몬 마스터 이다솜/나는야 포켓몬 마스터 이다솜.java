import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//도감에 수록되어있는 포켓몬 수
		int M = sc.nextInt();//맞춰야하는 문제의 개수
		
		Map<String, Integer> map1 = new HashMap<>();
		Map<Integer, String> map2 = new HashMap<>();
		
		for(int i=1; i<=N; i++) {
			String name = sc.next();
			map1.put(name, i);
			map2.put(i, name);
		}
		
		for(int i=0; i<M; i++) {
			String s = sc.next();
			
			//숫자가 입력된 경우
			if('0'<=s.charAt(0)&&s.charAt(0)<='9') {
				System.out.println(map2.get(Integer.parseInt(s)));
			}
			//문자가 입력된 경우
			else {
				System.out.println(map1.get(s));
			}
		}
	}
}