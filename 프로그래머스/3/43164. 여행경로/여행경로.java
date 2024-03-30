import java.util.*;

class Solution {
    
    boolean[] visited;
    String[] answer;
    boolean isComplete = false;
    
    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length+1];
        visited = new boolean[tickets.length];

        // 도착지 알파벳 기준으로 티켓 정렬
        Arrays.sort(tickets, Comparator.comparing(a -> a[1]));
        
        DFS(0, "ICN", tickets);
        
        return answer;
    }
    
    private void DFS(int cnt, String curr, String[][] tickets){
        if(isComplete) return;
        
        answer[cnt] = curr;
        
        if(cnt == tickets.length){
            isComplete = true;
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(curr.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                DFS(cnt+1, tickets[i][1], tickets);
                visited[i] = false;
            }    
        }
    }
}