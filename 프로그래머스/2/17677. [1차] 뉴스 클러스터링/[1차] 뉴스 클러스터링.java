import java.util.*;
import java.lang.StringBuilder;

class Solution {
    public int solution(String str1, String str2) {
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        
        Set<String> total = new HashSet<>();
        Map<String, Integer> set1 = new HashMap<>();
        Map<String, Integer> set2 = new HashMap<>();
        
        StringBuilder sb;
        for(int i=0; i<c1.length-1; i++){
            if(isAlphabet(c1[i]) && isAlphabet(c1[i+1])){
                sb = new StringBuilder();
                sb.append(c1[i]).append(c1[i+1]);
                
                if(set1.containsKey(sb.toString().toLowerCase())){
                    set1.replace(sb.toString().toLowerCase(), set1.get(sb.toString().toLowerCase())+1);
                }else{
                    set1.put(sb.toString().toLowerCase(),1);
                    total.add(sb.toString().toLowerCase());
                }
            }
        }
        
        for(int i=0; i<c2.length-1; i++){
            if(isAlphabet(c2[i]) && isAlphabet(c2[i+1])){
                sb = new StringBuilder();
                sb.append(c2[i]).append(c2[i+1]);
                
                if(set2.containsKey(sb.toString().toLowerCase())){
                    set2.replace(sb.toString().toLowerCase(), set2.get(sb.toString().toLowerCase())+1);
                }else{
                    set2.put(sb.toString().toLowerCase(),1);
                    total.add(sb.toString().toLowerCase());
                }
            }
        }
        
        if(total.size()==0) return 65536;
        
        for(String s:total) System.out.println(s);
        
        int union = 0; // 합집합 크기
        int intersection = 0; // 교집합 크기
        for(String s : total){
            if(set1.containsKey(s) && set2.containsKey(s)){
                union += Math.max(set1.get(s), set2.get(s));
                intersection += Math.min(set1.get(s), set2.get(s));
            }else if(set1.containsKey(s)){
                union += set1.get(s);
            }else{
                union += set2.get(s);
            }
        }   
        
        double J = (double)intersection/union;
        
        return (int) (J*65536);
    }
    
    boolean isAlphabet(char c){
        if(c>=65 && c<=90) return true;
        if(c>=97 && c<=122) return true;
        
        return false;
    }
}
