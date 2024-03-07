import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        
        int select = nums.length/2; // 선택해야하는 포켓몬 마리 수
        int type = set.size(); // 포켓몬 종류수
        
        if(type >= select) return select;
        
        return type;
    }
}