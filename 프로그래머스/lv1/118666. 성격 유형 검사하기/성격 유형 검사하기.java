import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] score = new int[8];
        char[] p = {'R','T','C','F','J','M','A','N'};
        Map<Character, Integer> map = new HashMap<>();
        map.put('R',0);
        map.put('T',1);
        map.put('C',2);
        map.put('F',3);
        map.put('J',4);
        map.put('M',5);
        map.put('A',6);
        map.put('N',7);
        
        for(int i=0; i<survey.length; i++){
            char[] c = survey[i].toCharArray();
            switch(choices[i]){
                case 1:
                    score[map.get(c[0])] += 3;
                    break;
                case 2:
                    score[map.get(c[0])] += 2;
                    break;
                case 3:
                    score[map.get(c[0])] += 1;
                    break;
                case 5:
                    score[map.get(c[1])] += 1;
                    break;
                case 6:
                    score[map.get(c[1])] += 2;
                    break;
                case 7 :
                    score[map.get(c[1])] += 3;
                    break;
            }
        }
        
        for(int i=0; i<=6; i+=2){
            if(score[i]>= score[i+1]) answer += p[i];
            else answer += p[i+1];
        }
        return answer;
    }
}