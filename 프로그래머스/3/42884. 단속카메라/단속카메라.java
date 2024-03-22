import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        // 진출 지점 기준으로 오름차순 정렬
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        
        // 0번째 차량의 진출 지점에 카메라 설치
        int camera = 0;
        int answer = 1;

        for(int i=1; i<routes.length; i++){
            // i번째 차량의 진입 지점이 카메라보다 뒤면 카메라 설치
            if(routes[i][0] > routes[camera][1]){
                camera = i;
                answer++;
            }
        }
        
        return answer;
    }
}