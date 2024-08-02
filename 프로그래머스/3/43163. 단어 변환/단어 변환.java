class Solution {

    int min = Integer.MAX_VALUE;
    String[] word;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        word = words;
        visited = new boolean[words.length];
        
        convert(begin, target, 0);
        
        if(min == Integer.MAX_VALUE) return 0;
        return min;
    }
    
    void convert(String curr, String target, int n){
        // min보다 변환 횟수가 크면 리턴
        if(n > min) return;
        
        // target 만들었으면 min 갱신
        if(curr.equals(target)){
            min = Math.min(min, n);
            return;
        }
        
        // 아직 거쳐가지 않은 단어고 변환 가능하면 변환
        for(int i=0; i<word.length; i++){
            if(!visited[i] && convertible(curr, word[i])){
                visited[i] = true;
                convert(word[i], target, n+1);
                visited[i] = false;
            }
        }
    }
    
    // 알파벳 다른 횟수 카운트 => 2개 이상 다르면 false 반환, 1개만 다르면 true 반환
    boolean convertible(String curr, String target){
        int cnt = 0;
        
        for(int i=0; i<curr.length(); i++){
            if(curr.charAt(i) != target.charAt(i)) cnt++;
            
            if(cnt>1) return false;
        }
        
        return true;
    }
}