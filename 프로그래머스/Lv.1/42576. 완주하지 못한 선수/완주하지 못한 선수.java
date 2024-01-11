import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<completion.length; i++){
            if(map.containsKey(completion[i])){
                map.replace(completion[i], map.get(completion[i])+1);
            } else{
                map.put(completion[i], 1);
            }
        }
        
        for(int i=0; i<participant.length; i++){
            String player = participant[i];
            if(map.containsKey(player)){
                if(map.get(player)==1) {
                    map.remove(player);
                } else{
                    map.replace(player, map.get(player)-1);
                } 
            }else{
                return player;
            }
        }
        
        return "";
    }
}