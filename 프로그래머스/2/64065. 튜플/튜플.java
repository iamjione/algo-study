import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    
    public int[] solution(String s) {
        
        String[] arr = s.substring(2, s.length() - 2).split("\\},\\{");
        
        // 길이 기준으로 정렬
        Arrays.sort(arr, new Comparator<String>() {
	        @Override
	        public int compare(String o1, String o2) {
		        return o1.length() - o2.length();
	        }
        });

        int[] answer = new int[arr.length];
        
        answer[0] = Integer.parseInt(arr[0]);
        set.add(answer[0]);
        for (int i = 1; i < arr.length; i++) {
            answer[i] = findNumber(arr[i]);
        }
        
        return answer;
    }
    
    int findNumber(String s){
        String[] arr = s.split(",");
        
        int n;
        for(int i=0; i<arr.length; i++){
            n = Integer.parseInt(arr[i]);
            if(!set.contains(n)) {
                set.add(n);
                return n;
            }
        }
        
        return 0;
    }
}