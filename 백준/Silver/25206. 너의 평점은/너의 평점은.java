import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Double ans = 0.0;//학점 × 과목평점의 합
		Double sum = 0.0;//학점 총합
		
		for(int i=0; i<20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();//과목명
			Double score = Double.parseDouble(st.nextToken());//학점
			String grade = st.nextToken();//등급(과목평점)
			
			if(grade.equals("P")) continue;//등급이 P인 과목 계산에서 제외
			
			sum += score;//학점 sum에 더해주기	
			
			Double nGrade = 0.0;//등급을 점수로 변환한 값
			switch(grade) {
			case "A+":
				nGrade = 4.5;
				break;
			case "A0":
				nGrade = 4.0;
				break;
			case "B+":
				nGrade = 3.5;
				break;
			case "B0":
				nGrade = 3.0;
				break;
			case "C+":
				nGrade = 2.5;
				break;
			case "C0":
				nGrade = 2.0;
				break;
			case "D+":
				nGrade = 1.5;
				break;
			case "D0":
				nGrade = 1.0;
				break;
			}
			
			ans += score*nGrade;
		}
		
		System.out.println(ans/sum);
	}

}