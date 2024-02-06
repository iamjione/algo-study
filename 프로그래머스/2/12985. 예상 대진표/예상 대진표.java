class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        // a와 b가 만날 때까지 a와 b가 이겨서 새로운 번호 배정받기
        while(a != b){
            answer++;
            
            a = play(a);
            b = play(b);
        }

        return answer;
    }
    
    /*
    * n번이 게임에서 이겼을 때 새로 배정될 번호 리턴하는 함수
    */
    private int play(int n){
        // n이 짝수면 이겼을 때 n/2번
        if(n%2 == 0) return n/2;
        // n이 홀수면 이겼을 때 n/2+1번
        else return n/2+1;
    }
}
