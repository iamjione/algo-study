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
    static boolean[] visited;
    static int[] items,d;
    static int n,m,sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());//지역 개수
        m = Integer.parseInt(st.nextToken());//수색 범위
        int r = Integer.parseInt(st.nextToken());//길 개수

        //items 배열에 각 지역의 아이템 수 입력받아서 저장
        items = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }

        adjList = new ArrayList[n+1];
        for(int i=1; i<n+1; i++) adjList[i] = new ArrayList<>();
        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());//시작점
            int v = Integer.parseInt(st.nextToken());//도착점
            int w = Integer.parseInt(st.nextToken());//가중치
            //양방향
            adjList[u].add(new Node(v,w));
            adjList[v].add(new Node(u,w));
        }

        d = new int[n+1];//최단 거리 입력할 배열

        int max = 0;
        for(int i=1; i<n+1; i++){//시작 정점
            dijkstra(i);
            if(sum>max) max = sum;//얻을 수 있는 아이템 수의 최대값 갱신
        }
        System.out.println(max);
    }

    private static void dijkstra(int start) {
        visited = new boolean[n+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;
        sum = 0;//얻을 수 있는 아이템 수
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            int curr = pq.poll().v;

            if(visited[curr]) continue;//이미 방문한 곳이면 컨티뉴

            visited[curr] = true;
            //최단거리가 수색 범위m 내에 있으면 해당 정점의 아이템 수 sum에 더해주기
            if(d[curr]<=m) sum+=items[curr];
            for(Node n : adjList[curr]) {
                int next = n.v;
                if (visited[n.v]) continue;
                d[next] = Math.min(d[next], d[curr] + n.w);
                pq.add(new Node(next, d[next]));
            }
        }
    }
}