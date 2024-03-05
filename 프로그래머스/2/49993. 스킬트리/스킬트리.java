import java.util.*;

class Solution {

    Queue<Character> q;

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++){
            if(isPossible(skill, skill_trees[i])) answer++;
        }
        return answer;
    }
    
    private boolean isPossible(String skill, String skillTree){
        q = new ArrayDeque<>();
        for(int i=0; i<skill.length(); i++){
            q.offer(skill.charAt(i));
        }
        
        for(int i=0; i<skillTree.length(); i++){
            if(q.contains(skillTree.charAt(i))){
                if(q.peek()==skillTree.charAt(i)){
                    q.poll();
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}