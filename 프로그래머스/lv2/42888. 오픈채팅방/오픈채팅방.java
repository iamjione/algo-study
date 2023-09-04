import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Queue<String[]> q = new ArrayDeque<>();
        Map<String, String> users = new HashMap<>(); // Key: 아이디, Value: 닉네임
        
        for(int i=0; i<record.length; i++){
            String line = record[i];
            String[] words = line.split(" ");
            if(words[0].equals("Enter")){
                if(users.get(words[1]) == null) users.put(words[1],words[2]);
                else users.replace(words[1],words[2]);
                
                q.add(new String[] {words[1], words[0]});
            }else if(words[0].equals("Leave")){
                q.add(new String[] {words[1], words[0]});
            }else{ // "Change"
                users.replace(words[1],words[2]);
            }
        }
        String[] answer = new String[q.size()];
        int idx = 0;
        while(!q.isEmpty()){
            if(q.peek()[1].equals("Enter")){
                answer[idx++] = users.get(q.poll()[0])+"님이 들어왔습니다.";
            }else{
                answer[idx++] = users.get(q.poll()[0])+"님이 나갔습니다.";
            }
        }
        return answer;
    }
}