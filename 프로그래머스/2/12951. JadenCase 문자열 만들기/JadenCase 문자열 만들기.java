class Solution {
    public String solution(String s) {
        String answer = "";
        
        char c;
        boolean blank = true;
        for(int i=0; i<s.length(); i++){
            c = s.charAt(i);
            
            if(c == ' '){
                blank = true;
            } else if(blank){
                c = (char) Character.toUpperCase(c);
                blank = false;
            } else{
                c = (char) Character.toLowerCase(c);
                blank = false;
            }
            
            answer += c;
            
        }
        
        return answer;
    }
}