import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 사람 수
		int[] arr = new int[N];

		Set<Integer> set = new HashSet<>(); // 사람들이 원하는 용량 저장할 집합
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			set.add(arr[i]);
		}
		
		int max = 0; // 답으로 출력할 최장 연속 구간 길이
		int prev; // 앞사람이 원하는 용량
		int len; // 현재까지 연속 구간 길이
		for(int n : set) {
			prev = -1;
			len = 0;
			
			for(int i=0; i<N; i++) {
				if(arr[i] == n) continue;
				
				if(arr[i]==prev) {
					// 앞 사람이랑 용량 같으면 len증가
					len++;
				}else {
					// 앞 사람이랑 용량 다르면 최장 연속 구간 업데이트하고
					// prev는 현재 용량, len는 1로 초기화
					max = Math.max(max, len);
					prev = arr[i];
					len = 1;
				}
				
			}
			max = Math.max(max, len);
		}
		
		System.out.println(max);
	}
	
}