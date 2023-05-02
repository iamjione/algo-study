import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//채팅방 기록 수
		
		Set<String> set = new HashSet<>();
		int cnt = 0;//곰곰티콘 사용 횟수
		for(int i=0; i<N; i++) {
			String s = sc.next();
			if(s.equals("ENTER")) {
				cnt += set.size();//곰곰티콘 사용 횟수 카운트
				set = new HashSet<>();//집합 초기화
			//ENTER가 아닌 유저 닉네임이면 set에 유저 닉네임 추가
			}else if(i==N-1){
				set.add(s);
				//i가 N-1이면 곰곰티콘 사용 횟수에 집합 크기 더해주기
				cnt += set.size();
			}else{
				set.add(s);
			}
		}
		System.out.println(cnt);
	}
}