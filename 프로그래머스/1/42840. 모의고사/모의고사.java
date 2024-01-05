import java.util.*;
import java.lang.Math;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int[][] check = {{1, 2, 3, 4, 5}, 
                         {2, 1, 2, 3, 2, 4, 2, 5}, 
                         {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        
        int[] score = new int[3];
        
        for(int i=0; i<answers.length; i++){
            for(int j=0; j<3; j++){
                if(answers[i]==check[j][i%check[j].length]) score[j]++;
            } 
        }
        
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        
        for(int i=0; i<3; i++){
            if(score[i] == max) answer.add(i+1);
        }
        
        return answer;
    }
}