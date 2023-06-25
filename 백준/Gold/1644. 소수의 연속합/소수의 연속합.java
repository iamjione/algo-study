import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		boolean[] primeNumber = new boolean[N+1];
		Arrays.fill(primeNumber, true);
		
		//소수 아닌 수 체크
		for(int i=2; i*i<=N; i++){
			if(primeNumber[i]){
	            for(int j=i*i; j<=N; j+=i) primeNumber[j] = false;                
	        }        
	    }
		
		//리스트에 소수 저장
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=2; i<=N; i++) {
			if(primeNumber[i]) list.add(i);
		}

		
		//연속된 소수의 합이 N인 경우 카운트
		int cnt = 0;
		int sum = 0;
		int start=0, end=0;
		
        while(true) {
        	if(sum==N) cnt++;
        	
        	if(sum>=N) sum -= list.get(start++);
        	else {//sum<N
        		if(end==list.size()) break;
        		sum += list.get(end++);
        	}        	
        }
		System.out.println(cnt);
	}

}