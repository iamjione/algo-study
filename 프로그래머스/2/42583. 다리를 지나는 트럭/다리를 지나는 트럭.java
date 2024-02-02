import java.util.*;

class Solution {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;
        int idx = 0;
        
        Queue<Truck> q = new ArrayDeque<>();
        
        // 첫번째 트럭이 다리에 진입한 시간 큐에 넣기
        q.offer(new Truck(time++, truck_weights[idx]));
        int curr = truck_weights[idx++]; // 현재 다리를 건너는 트럭의 총 무게
        
        while(!q.isEmpty()){
            // 다리 다 건넌 트럭 큐에서 제거
            if(time - q.peek().s == bridge_length){
                curr -= q.poll().w;
            }
            
            // 아직 대기 중인 트럭이 있고 트럭이 다리에 올라갈 수 있으면 큐에 넣기
            if(idx < truck_weights.length && curr+truck_weights[idx] <= weight){
                q.offer(new Truck(time, truck_weights[idx]));
                curr += truck_weights[idx++];
            }
            
            time++;
        }
        
        return time-1;
    }
    
    class Truck{
        int s;
        int w;
        
        public Truck(int s, int w){
            this.s = s;
            this.w = w;
        }
    }
}