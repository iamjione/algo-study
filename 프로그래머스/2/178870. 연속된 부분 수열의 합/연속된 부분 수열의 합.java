class Solution {
    
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[1] = 2000000; // 최대값으로 갱신
        
        int start = 0;
        int end = 0;
        int sum = 0;

        while(start <= end){
            // 합이 k이고 기존 부분 수열보다 길이 짧으면 답 갱신
            if(sum == k && answer[1]-answer[0] > end-1-start){
                answer[0] = start;
                answer[1] = end-1;
                sum -= sequence[start];
                start++;
            // 합이 k보다 작으면 end 오른쪽으로 한칸 이동
            }else if(sum<k){
                if(end>=sequence.length) break; // end가 배열 넘어갔으면 반복분 끝내기
                sum += sequence[end];
                end++;
            // 합이 k보다 크면 start 오른쪽으로 한칸 이동
            }else{
                sum -= sequence[start];
                start++;
            }
        }
        
        return answer;
    }
}