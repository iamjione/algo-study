import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        // 작업을 우선순위 큐에 넣기
        PriorityQueue<Job> pq = new PriorityQueue<>();
        
        for(int i=0; i<jobs.length; i++){
            pq.add(new Job(jobs[i][0], jobs[i][1]));
        }
        
        // 우선 순위 큐가 빌때까지 현재 실행 가능한 작업 중 가장 빨리 끝나는 작업 실행하기
        int curr = 0;
        int sum = 0;
        int min = 2000;
        List<Job> tmp = new LinkedList<>();
        
        while(!pq.isEmpty()){
            Job job = pq.poll();
            if(job.start <= curr){
                curr += job.duration;
                sum += curr - job.start;
                
                for(Job j : tmp) pq.add(j);
                tmp.clear();
            }else{
                tmp.add(job);
                if(min>job.start) min = job.start;
            }
            
            if(pq.isEmpty() && !tmp.isEmpty()){
                for(Job j : tmp) pq.add(j);
                tmp.clear();
                
                curr = min;
                min = 2000;
            }
        }
        
        return sum/jobs.length;
    }
    
    class Job implements Comparable<Job>{
        int start;
        int duration;
        
        public Job(int start, int duration){
            this.start = start;
            this.duration = duration;
        }
        
        // 빨리 끝나는 작업 순으로 정렬
        @Override
        public int compareTo(Job o){
            return this.duration-o.duration;
        }
    }
}