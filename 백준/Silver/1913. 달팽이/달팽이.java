import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] arr = new int[N][N];
		int[] ans = new int[2];
		
		int num = N * N;
        int r = 0, c = 0;
        
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        int d = 0;

        arr[r][c] = num--;

        while (num > 0) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 0) {
                r = nr;
                c = nc;
                arr[r][c] = num--;
            } else {
                d = (d + 1) % 4;
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
                
                if (arr[i][j] == M) {
                    ans[0] = i+1;
                    ans[1] = j+1;
                }
            }
            System.out.println();
        }
        
        System.out.println(ans[0] + " " + ans[1]);
		
	}

}