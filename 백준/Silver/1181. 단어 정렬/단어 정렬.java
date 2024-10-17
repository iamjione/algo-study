import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		LinkedList<String>[] list = new LinkedList[51];
		for(int i=0; i<51; i++) {
			list[i] = new LinkedList<>();
		}
		
		String word;
		for(int i=0; i<N; i++) {
			word = sc.next();
			list[word.length()].add(word);
		}
		
		for(int i=1; i<51; i++) {
			Collections.sort(list[i]);
		}
		
		String prev = "";
		for(int i=1; i<51; i++) {
			if(list[i].isEmpty()) continue;
			
			for(String s : list[i]) {
				if(s.equals(prev)) continue;
				System.out.println(s);
				prev = s;
			}
		}
	}

}