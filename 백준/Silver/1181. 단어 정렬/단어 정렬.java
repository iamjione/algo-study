import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		
        // 단어 개수 입력받기
        Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
        
        //단어 배열에 넣기
		String[] arr = new String[N];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			arr[i] = str;
		}

		// 정렬
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					return o1.length() - o2.length();
				}
			}
		});

		// 중복 빼고 출력
		for (int i = 0; i < N-1; i++) {
			if (arr[i].equals(arr[i+1])) {
				continue;
			}
			System.out.println(arr[i]);
		}
		System.out.println(arr[N-1]);

	}

}