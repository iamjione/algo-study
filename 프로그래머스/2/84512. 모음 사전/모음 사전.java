class Solution {
    int answer = 0;
    char[] vowel = {'A', 'E', 'I', 'O', 'U'};
    boolean done = false;
    
    public int solution(String word) {
        makeWord("", word);
        return answer;
    }
    
    private void makeWord(String curr, String word){
        if(done) return;
        
        if(curr.equals(word)){
            done = true;
            return;
        }
        
        answer++;
        
        if(curr.length() == 5) return;
        
        
        for(int i=0; i<5; i++){
            makeWord(curr+vowel[i], word);
        }
        
    }
}