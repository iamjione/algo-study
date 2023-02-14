import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {

			char[] fn = sc.next().toCharArray();// 함수 입력받기

			int n = sc.nextInt();// 배열크기

			String s = sc.next();
			String s2 = s.substring(1, s.length() - 1);
			String[] arr = s2.split(",");// 배열입력받기

			LinkedList<String> list = new LinkedList<>();
			if(!arr[0].equals("")) {
				for (String x : arr)
					list.add(x);
			}//배열 linkedlist로 옮겨주기

			boolean reverse = false;// 뒤집었는지 표시
			boolean e = false;// 에러인지 표시

			for (int i = 0; i < fn.length; i++) {
				if (fn[i] == 'R') {
					reverse = !reverse;
				} else { // fn[i]=='D'
					if (list.isEmpty()) {// arr빈 배열일 때
						e = true;
						break;
					} else {// 빈 배열 아닐 때
						if (reverse == true) {
							list.removeLast();// 뒤집힌 상태면 끝값빼기
						} else
							list.remove();// 아니면 첫번째값 빼기
					}
				}
			}
			if(e==false) {
				StringBuilder sb = new StringBuilder("[");
		        while(!list.isEmpty()){
		            if(reverse)
		                sb.append(list.removeLast());
		            else
		                sb.append(list.removeFirst());
		            if(list.size() != 0)
		                sb.append(',');
		        }
		        sb.append(']');
		        System.out.println(sb);
			}else System.out.println("error");	
		}
	}
}