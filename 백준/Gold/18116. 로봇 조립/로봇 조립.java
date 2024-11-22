import java.io.*;
import java.util.*;

public class Main {
    static int[] p = new int[1000001];
    static int[] size = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());

        // make set
        for (int i = 1; i <= 1000000; i++) {
            p[i] = i;
            size[i] = 1;
        }

        char operation;
        int a, b;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            operation = st.nextToken().charAt(0);

            if (operation == 'I') {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                
                union(a, b);
            } else {
                a = Integer.parseInt(st.nextToken());
                sb.append(size[find(a)]).append('\n');
            }
        }
        System.out.print(sb.toString());
    }

    private static int find(int x) {
        if (x != p[x]) p[x] = find(p[x]);
        return p[x];
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return;

        if (size[x] < size[y]) {
        	p[x] = y;
        	size[y] += size[x];
        }else {
        	p[y] = x;
        	size[x] += size[y];        	
        }

    }
}