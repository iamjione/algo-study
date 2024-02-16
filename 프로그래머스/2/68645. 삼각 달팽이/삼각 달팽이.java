class Solution {
    public int[] solution(int n) {
        if(n==1) return new int[] {1};
        
        int[][] arr = new int[n][n];
        int len = n*(n+1)/2;
        int r = 0;
        int c = 0;
        int num = 1;
        
        while(num<=len){
            // 아래로 이동
            while(r<n && arr[r][c]==0){
                arr[r][c] = num++;
                r ++;
            }
            r--;
            c++;
            // 오른쪽으로 이동
            while(c<n && arr[r][c]==0){
                arr[r][c] = num++;
                c ++;
            }
            c-=2;
            r--;
            
            // 왼쪽 대각선 위로 이동
            while(arr[r][c]==0){
                arr[r][c] = num++;
                c--;
                r--;
            }
            r += 2;
            c++;
        }
        
        
        int[] answer = new int[len];
        int idx = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] != 0) answer[idx++] = arr[i][j];    
            }
        }

        return answer;
    }
}