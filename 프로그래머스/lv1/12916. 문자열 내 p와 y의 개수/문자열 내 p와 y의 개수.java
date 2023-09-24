class Solution {
    boolean solution(String s) {
        char[] arr = s.toCharArray();
        int pCnt = 0;
        int yCnt = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 'p' || arr[i] == 'P') pCnt++;
            else if(arr[i] =='y' || arr[i] == 'Y') yCnt++;
        }
        if(pCnt==yCnt) return true;
        return false;
    }
}