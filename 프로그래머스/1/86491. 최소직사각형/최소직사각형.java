import java.lang.Math;

class Solution {
    public int solution(int[][] sizes) {
        
        int max = 0; // 가로 세로 중 큰 값의 최대값
        int min = 0; // 가로 세로 중 작은 값의 최대값
        
        
        for(int i=0; i<sizes.length; i++){
            max = Math.max(max, Math.max(sizes[i][0], sizes[i][1]));
            min = Math.max(min, Math.min(sizes[i][0], sizes[i][1]));
        }
        
        return max*min;
    }
}