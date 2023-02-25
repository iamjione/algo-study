import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//듣도 못한 사람 수
		int M = sc.nextInt();//보도 못한 사람 수
		
		HashSet<String> set = new HashSet<>();
		ArrayList<String> list = new ArrayList<>();
		//듣도 못한 사람
		for(int i=0; i<N; i++) {
			set.add(sc.next());
		}
		//보도 못한 사람
		//듣도 못한 사람에 이름 있으면 list에 추가
		for(int i=0; i<M; i++) {
			String name = sc.next();
			if(set.contains(name)) {
				list.add(name);				
			}
		}
		Collections.sort(list);;
		System.out.println(list.size());
		for(String s:list) System.out.println(s);
	}
}