import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 아이들 수
		int M = sc.nextInt(); // 색상 수
		
		int[] arr = new int[M];
		int e = Integer.MIN_VALUE;
		for(int i=0; i<M; i++) {
			arr[i] = sc.nextInt();
			e = Math.max(e, arr[i]);
		}
		
		int s = 1;
		int mid;
		int min = Integer.MAX_VALUE;
		int cnt; // 질투심의 최솟값이 mid일 때 필요한 학생 수
		while(s<=e) {
			mid = (s+e)/2;
			
			cnt = 0;
			for(int i=0; i<M; i++) {
				cnt += arr[i]/mid;
				if(arr[i]%mid != 0) cnt++;
			}
			
			if(cnt > N) {
				s = mid+1;
			}else {
				min = Math.min(min, mid);
				e = mid-1;
			}
		}
		
		System.out.println(min);

	}

}