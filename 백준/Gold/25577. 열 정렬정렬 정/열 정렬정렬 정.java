import java.util.*;

public class Main {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] arr = new int[N];
        int[] sortedArr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            sortedArr[i] = arr[i];
        }
        
        Arrays.sort(sortedArr);
        
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            indexMap.put(sortedArr[i], i);
        }

        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int sortedIdx = indexMap.get(arr[i]);

            adjList[i].add(sortedIdx);
            adjList[sortedIdx].add(i);
        }

        visited = new boolean[N];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(i);
            }
        }

        System.out.println(N - cnt);
    }

    static void dfs(int curr) {
        visited[curr] = true;

        for (int next : adjList[curr]) {
            if (!visited[next]) dfs(next);
        }
    }
}