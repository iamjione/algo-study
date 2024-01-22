class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2]; // 이진 변환 횟수, 제거된 0의 개수
        
        int cnt;
        while(!s.equals("1")){
            answer[0]++;
            
            cnt = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '1') cnt++;
            }
        
            answer[1] += s.length() - cnt;
            
            s = Integer.toBinaryString(cnt);
        }
        
        return answer;
    }
}