import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Arrays.sort(reserve);
        
        Set<Integer> set = new HashSet<>();
        
        for(int num : lost){
            set.add(num);
        }
        
        LinkedList<Integer> list = new LinkedList<>();
        
        for(int num : reserve){
            if(set.contains(num)){
                set.remove(num);
            }else{
                list.add(num);
            }
        }
        
        for(int num : list){
            if(set.contains(num-1)){
                set.remove(num-1);
            }else if(set.contains(num+1)){
                set.remove(num+1);
            }
        }
        
        return n-set.size();
    }
}