import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        Comparator<String> compare = new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                return (y + x).compareTo(x + y);
            }
        };
        
        // numbers를 문자열 배열로 변환
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 정렬
        Arrays.sort(arr, compare);

        // 제일 큰 수가 0이면 0 반환
        if (arr[0].equals("0")) {
            return "0";
        }

        // 정렬된 숫자를 이어 붙여서 문자열로 반환
        StringBuilder sb = new StringBuilder();
        for (String number : arr) {
            sb.append(number);
        }

        return sb.toString();
    }
}