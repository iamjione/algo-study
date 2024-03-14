class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        double range = 2*w+1; // 기지국 설치시 전파 전달되는 범위
        
        // 전파가 통하지 않는 연속되는 모든 아파트에
        // 전파를 전달하기 위해 필요한 기지국 개수 카운트
        int start = 1;
        for(int station: stations){
            answer += Math.ceil((station-w-start)/range);
            start = station+w+1;
        }
        if(start<=n) answer += Math.ceil((n+1-start)/range);
        

        return answer;
    }
    
}