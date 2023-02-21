import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		Map<Integer, Integer> map = new HashMap<>();//키: 숫자, 값:카운트
		
		int N = sc.nextInt();//상근이가 갖고 있는 숫자 개수
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			if(map.get(num)==null) map.put(num, 1);//키 없으면 값에 1 넣어줌
			else map.put(num, map.get(num)+1);//키가 이미 존재하면 원래 값에 1더해줌	
		}
		
		int M = sc.nextInt();//상근이가 몇개 가지고 있는지 구해야할 숫자 카드 개수
		for(int i=0; i<M; i++) {
			int num = sc.nextInt();
			int ans;//정답 변수
			if(map.get(num)==null) ans=0;//null이면 0으로 바꿔줌
			else ans = map.get(num);//null이 아니면 키가 num일때의 값을 답으로!
			sb.append(ans + " ");
		}
		System.out.println(sb);
	}
}