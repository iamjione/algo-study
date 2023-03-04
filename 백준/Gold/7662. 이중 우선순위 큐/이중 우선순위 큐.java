import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			//key: 입력받은 숫자, value: 숫자의 개수
			TreeMap<Integer, Integer> tm = new TreeMap<>();
			
			int N = sc.nextInt();//연산 횟수
			for(int i=0; i<N; i++) {
				String cmd = sc.next();
				switch(cmd){
				case "I":
					int num = sc.nextInt();
					if(tm.containsKey(num)) tm.put(num, tm.get(num)+1);
					else tm.put(num, 1);
					break;
				case "D":
					int n = sc.nextInt();
					if(!tm.isEmpty() && n==1) {
						//최대값 제거
						int maxV = tm.get(tm.lastKey());
						if(maxV==1) tm.remove(tm.lastKey());
						else tm.put(tm.lastKey(),maxV-1);
					}else if(!tm.isEmpty() && n==-1){
						//최소값 제거
						int minV = tm.get(tm.firstKey());
						if(minV==1) tm.remove(tm.firstKey());
						else tm.put(tm.firstKey(),minV-1);
					}
				}
			}
			if(tm.size()==0) System.out.println("EMPTY");
			else System.out.println(tm.lastKey()+" "+tm.firstKey());
		}
	}
}