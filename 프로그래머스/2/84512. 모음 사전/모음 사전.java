class Solution {
    
    static char[] vowel = {'A','E','I','O','U'};
    static int cnt = 0;
    static int answer = 0;
    
    public int solution(String word) {

        makeWord("", word);
        
        return answer;
    }
    
    void makeWord(String curr, String word){
        if(answer != 0) return;
        
        if(curr.equals(word)) {
            answer = cnt;
            return;
        }
        
        if(curr.length()>=5){
            return;
        }
        
        for(int i=0; i<5; i++){
            cnt++;
            makeWord(curr+vowel[i], word);
        }
    }
}