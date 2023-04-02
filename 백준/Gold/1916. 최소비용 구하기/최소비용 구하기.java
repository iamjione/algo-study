import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node>{
        int v,w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w-o.w;
        }
    }

    static ArrayList<Node>[] adjList;
    static int[] d;
    static boolean[] visited;
    static int start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());//도시 개수
        int M = Integer.parseInt(br.readLine());//버스개수

        //인접 리스트 만들기
        adjList = new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            adjList[i] = new ArrayList<>();
        }
        //출발 도시, 도착 도시, 비용 인접 리스트에 저장
        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());//출발 도시
            int v = Integer.parseInt(st.nextToken());//도착 도시
            int w = Integer.parseInt(st.nextToken());//버스 비용

            adjList[u].add(new Node(v,w));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());//출발 도시
        end = Integer.parseInt(st.nextToken());//도착 도시

        d = new int[N+1];//최소 비용 저장할 배열
        Arrays.fill(d,Integer.MAX_VALUE);//최대값으로 초기화해줌
        d[start]=0;//출발점에서 출발점 가는 비용은 0

        visited = new boolean[N+1];// 방문체크

        dijkstra();
        System.out.println(d[end]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            int curr = pq.poll().v;//현재 탐색 정점

            if(curr==end) return;//도착 도시에 도착했으면 메서드 종료

            if(visited[curr]) continue;//방문한 곳이면 컨티뉴
            
            visited[curr] = true;//방문 표시해주기
            //현재 탐색 정점의 인접 정접 중 방문하지 않은 곳있으면 최소 비용 갱신
            for(Node n : adjList[curr]){
                int next = n.v;//curr의 인접 정점
                if(visited[next]) continue;//이미 방문한 곳이면 컨티뉴
                //기존 비용과 curr를 경유해서 오는 경우 비교해서 최소 비용 갱신
                d[next] = Math.min(d[next], d[curr]+n.w);
                pq.add(new Node(next,d[next]));
            }
        }
    }

}