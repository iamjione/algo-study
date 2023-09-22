class Solution {
    public String solution(String[] seoul) {
        int idx = 0; // 김서방의 위치
        
        for(int i=0; i<seoul.length; i++){
            if(seoul[i].equals("Kim")){
                idx = i;
                break;
            }
        }
        
        String answer = "김서방은 "+idx+"에 있다";
        return answer;
    }
}