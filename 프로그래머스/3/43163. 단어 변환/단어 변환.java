import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    
    int answer = 0;

    public int solution(String begin, String target, String[] words) {
        
        BFS(begin, target, words);
        
        return answer;
    }
    
    private void BFS(String begin, String target, String[] words){
        int len = words.length;
        int[] visited = new int[len+1]; // 방문 순서 배열
        Queue<Integer> q = new ArrayDeque<>();
        
        // begin과 한글자 차이나는 단어 큐에 넣기
        for(int i=0; i<len; i++){
            if(convert(begin, words[i])){
                q.offer(i);
                visited[i] = 1;
            }
        }
        
        // BFS 실시
        while(!q.isEmpty()){
            int curr = q.poll();
            
            // target과 같은 단어 찾은 경우 answer에 방문 순서 저장하고 메서드 종료
            if(words[curr].equals(target)){
                answer = visited[curr];
                return;
            }
            
            for(int i=0; i<len; i++){
                if(visited[i]==0 && convert(words[curr], words[i])){
                    q.offer(i);
                    visited[i] = visited[curr]+1;
                }
            }
        }
    }
    
    // curr => next 변환 가능 여부
    private boolean convert(String curr, String next){
        int diff = 0;
        for(int i=0; i<curr.length(); i++){
            if(curr.charAt(i) != next.charAt(i)) diff++;
            if(diff>1) return false;
        }
        
        return true;
    }
}