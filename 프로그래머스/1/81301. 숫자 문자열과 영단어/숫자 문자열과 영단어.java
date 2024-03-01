import java.util.*;

class Solution {
    
    Map<String, Integer> map = new HashMap<>();
    
    public int solution(String s) {
        saveMap(); // 맵에 영단어 & 숫자 저장
        
        return convertToInt(s);
    }
    
    int convertToInt(String s){
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)>=48 && s.charAt(i)<=57){
                // 숫자면 그대로 저장
                sb.append(s.charAt(i));
            }else{
                // 문자면 숫자로 변환해서 저장
                for(int j=i+3; j<=s.length(); j++){// 영단어 최소 길이 3이니까 i+3부터
                    if(map.containsKey(s.substring(i,j))){
                        sb.append(map.get(s.substring(i,j)));
                        i = j-1;
                        break;
                    }
                }
            }
        }
        return Integer.parseInt(sb.toString());
    }
    
    void saveMap(){
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
    }
}