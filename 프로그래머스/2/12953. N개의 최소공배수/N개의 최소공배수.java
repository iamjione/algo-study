class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        // arr의 최댓값 찾기
        for(int i = 0; i<arr.length; i++){
            if(arr[i]>answer) answer = arr[i];
        }
        
        boolean pass; // answer의 최소공배수 여부
        
        // answer가 arr의 모든 수의 공배수 일 때까지 
        // answer 값을 증가하면서 최소 공배수 찾기
        while(true){
            pass = true;
            for(int n : arr){
                if(answer%n != 0){
                    pass = false;
                    break;
                }
            }
            
            if(pass) break;
            else answer++;
        }
        
        return answer;
    }
}
