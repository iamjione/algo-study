import java.util.*;

class Solution {
    PriorityQueue<Integer> pq1 = new PriorityQueue<>();
    PriorityQueue<Integer> pq2 = new PriorityQueue<>();
    int curr = 1;
    
    public int[] solution(String[] operations) {
        for(int i=0; i<operations.length; i++){
            String[] s = operations[i].split(" ");
            String command = s[0];
            int num = Integer.parseInt(s[1]);
            if(curr == 1) execute1(command, num);
            else execute2(command, num);
        }
        
        return findAnswer();
    }
    
    private void execute1(String command, int num) {
        if (command.equals("I")) {
            pq1.offer(num);
        } else if (num == -1 && !pq1.isEmpty()) {
            pq1.poll();
        } else if (!pq1.isEmpty()) {
            transferElements(pq1, pq2);
            pq1.poll();
            curr = 2;
        }
    }

    private void execute2(String command, int num) {
        if (command.equals("I")) {
            pq2.offer(num);
        } else if (num == -1 && !pq2.isEmpty()) {
            pq2.poll();
        } else if (!pq2.isEmpty()) {
            transferElements(pq2, pq1);
            pq2.poll();
            curr = 1;
        }
    }

    private void transferElements(PriorityQueue<Integer> source, PriorityQueue<Integer> destination) {
        while (source.size() > 1) {
            destination.offer(source.poll());
        }
    }

    private int[] findAnswer() {
        int[] answer = new int[2];
        PriorityQueue<Integer> currentPQ = (curr == 1) ? pq1 : pq2;

        if (!currentPQ.isEmpty()) {
            answer[1] = currentPQ.poll();
            while (currentPQ.size() > 1) {
                currentPQ.poll();
            }
            answer[0] = currentPQ.poll();
        }

        return answer;
    }
}