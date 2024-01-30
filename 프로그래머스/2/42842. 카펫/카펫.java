class Solution {
    public int[] solution(int brown, int yellow) {
        // 전체 카펫의 가로 길이 x, 세로 길이 y
        // 노란색 부분의 가로 길이 x-2, 세로 길이 y-2
        // 2x^2 - (4+brown)x + 2(brown+yellow) = 0
        int a = 2;
        int b = -(4+brown);
        int c = 2*(brown+yellow);
        
        // 근의 공식 이용해서 가로 x값 계산 후 세로 y 값 계산
        int x = (-b+(int)Math.sqrt(b*b-4*a*c))/(2*a);
        int y = (brown+yellow)/x;
        
        return new int[] {x,y};
    }
}