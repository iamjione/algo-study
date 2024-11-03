class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int start = 1;
        int end = 100000;
        int mid;
        long total;
        
        while(start <= end){
            mid = (start+end)/2;
            
            total = 0;
            for(int i=0; i<diffs.length; i++){
                if(diffs[i] <= mid){
                    total += times[i];
                }else{
                    total += (times[i]+times[i-1])*(diffs[i] - mid) + times[i];
                }
            }
            
            if(total <= limit){
                answer = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        
        return answer;
    }
}