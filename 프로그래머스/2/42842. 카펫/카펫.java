class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int x, y; // 노란색의 가로, 세로 길이
        for(int i=1; i<=yellow; i++){
            if(yellow%i != 0) continue;
            
            x = yellow/i;
            y = i;
            
            if(x<y) break;
            
            if(2*(x+2) + 2*y == brown){
                answer[0] = x+2;
                answer[1] = y+2;
                
                break;
            }
        }
        
        return answer;
    }
}