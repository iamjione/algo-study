class Solution {
    public long[] solution(int n, long left, long right) {
        int l = Long.valueOf(left).intValue();
        int r = Long.valueOf(right).intValue();
        
        long[] answer = new long[r-l+1];
        
        int idx = 0;
        for(long i=left; i<=right; i++){
            answer[idx++] = Math.max(i%n, i/n)+1;
        }
        
        return answer;
    }
}