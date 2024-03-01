class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int idx = 0;
        while(idx<n){
            answer[idx] = (long) (1+idx)*x;
            idx++;
        }
        return answer;
    }
}