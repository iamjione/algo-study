class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        int n = number.length()-k; // number에서 숫자 k개 제거 후 남은 숫자 개수
        
        int startIdx = 0;
        int maxIdx;// 탐색 범위 내에서 가장 큰 숫자의 인덱스
        
        for(int i=0; i<n; i++){
            maxIdx = startIdx;
            for(int j=startIdx; j<=k+i; j++){
                if(number.charAt(j) > number.charAt(maxIdx)){
                    maxIdx = j;
                }
            }
            answer.append(number.charAt(maxIdx));// 가장 큰 숫자 answer에 넣기
            startIdx = maxIdx+1;// 가장 큰 숫자의 다음 숫자 부터 탐색 시작
        }

        return answer.toString();
    }
}