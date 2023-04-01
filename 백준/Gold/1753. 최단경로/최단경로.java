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
            this.v = v;//정점
            this.w = w;//가중치
        }

        @Override
        public int compareTo(Node o) {
            return this.w-o.w;
        }
    }

    static ArrayList<Node>[] adjList;
    static int[] d;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());//정점 개수
        int E = Integer.parseInt(st.nextToken());//간선 개수

        int start = Integer.parseInt(br.readLine());//시작 정점

        //인접 리스트
        adjList = new ArrayList[V+1];
        for(int i=1; i<V+1; i++) {
            adjList[i] = new ArrayList<Node>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());//시작점
            int v = Integer.parseInt(st.nextToken());//도착점
            int w = Integer.parseInt(st.nextToken());//가중치

            adjList[u].add(new Node(v,w));
        }

        d = new int[V+1];//최단 경로 저장할 배열
        Arrays.fill(d,Integer.MAX_VALUE);//최단 경로 최대값으로 초기화
        d[start] = 0;//시작점의 경로는 0
        visited = new boolean[V+1];//방문 표시할 배열
        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<V+1; i++){
            //경로 없으면 INF 있으면 최단 경로 출력
            if(d[i]==Integer.MAX_VALUE) sb.append("INF").append('\n');
            else sb.append(d[i]).append('\n');
        }
        System.out.println(sb);

    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            int curr = pq.poll().v;//현재 정점

            if(visited[curr]) continue;//이미 방문한 곳이면 컨티뉴

            visited[curr] = true;//방문한적 없으면 방문체크
            //현재 정점의 인접 정점 중 방문하지 않은 곳 있으면 최단 비용 갱신
            for(Node n : adjList[curr]){
                int next = n.v;//curr의 인접 정점
                if(visited[next]) continue;//이미 방문한 곳이면 컨티뉴
                //기존 비용과 curr를 경유해서 오는 경우 비교해서 최단 비용 갱신
                d[next] = Math.min(d[next], d[curr]+n.w);
                pq.add(new Node(next,d[next]));
            }
        }
    }

}