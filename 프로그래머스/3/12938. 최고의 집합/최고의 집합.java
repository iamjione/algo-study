class Solution {
    public int[] solution(int n, int s) {
        
        if(n>s) return new int[] {-1};
        
        int[] answer = new int[n];
        
        int a = (int) Math.ceil((double)s/(double)n);
        int b = (int) Math.floor((double)s/(double)n);
        int remainder = s%n;
        
        for(int i=0; i<n-remainder; i++) answer[i] = b;
        for(int i=n-remainder; i<n; i++) answer[i] = a;

        return answer;
    }
}