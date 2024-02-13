import java.util.*;

class Solution {
    
    Map<String, String> inTime = new HashMap<>(); // 차량 번호, 입차 시간 저장
    Map<String, Integer> totalTime = new HashMap<>(); // 차량 번호, 누적 시간 저장
    int[] f;
    
    public int[] solution(int[] fees, String[] records) {
        f = fees;
        List<String> carNumbers = new LinkedList<>();
        
        for(int i=0; i<records.length; i++){
            String[] record = records[i].split(" ");
            
            if(record[2].equals("IN")){
                // 입차인 경우 map에 차량 번호, 입차 시간 저장
                inTime.put(record[1], record[0]);
                if(!carNumbers.contains(record[1])) carNumbers.add(record[1]);
            }else{
                // 출차인 경우 해당 차량의 누적 주차 시간 저장
                recordTotalTime(record[1], inTime.get(record[1]), record[0]);
                inTime.remove(record[1]); // 입차 정보 삭제
            }
        }
        
        // 출차 기록 없는 차에 대해 23:59분 출차 처리
        for (String num : inTime.keySet()) {
            recordTotalTime(num, inTime.get(num), "23:59");
        }
        
        Collections.sort(carNumbers);
        
        int[] answer = new int[carNumbers.size()];
        int idx = 0;
        for(String num : carNumbers){
            answer[idx++] = calculate(num, totalTime.get(num));
        }
        
        return answer;
    }
    
    /*
    ** 차량번호가 num인 자동차의 총 주차장 사용 시간을 totalTime에 저장하는 메서드
    */
    public void recordTotalTime(String num, String in, String out){
        int time = convertTimeToMinute(out) - convertTimeToMinute(in);
    
        if(totalTime.containsKey(num)){
            // 이미 기록 있는 차 번호면 주차 시간 더해주기
            totalTime.replace(num, totalTime.get(num)+time);
        }else{
            // 기록 없으면 새롭게 저장
            totalTime.put(num, time);    
        }
    }
    
    /*
    ** 차량번호가 num인 자동차의 총 주차 요금을 계산하는 메서드
    */
    public int calculate(String num, int time){
        int extraTime = time-f[0]; // 기본 시간을 초과한 시간
        
        int fee = f[1];
        
        // 초과 시간에 대해 추가 요금 더하기
        if(extraTime>0){    
            fee += (int) Math.ceil((double) extraTime / f[2]) * f[3];
        }
        return fee;
    }
    
    /*
    ** 00:00 형식의 시간을 분으로 변환하는 메서드
    */
    public int convertTimeToMinute(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
    }
}