import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());// 도시 개수
        int m = Integer.parseInt(br.readLine());// 버스 개수

        int[][] adjMatrix = new int[n+1][n+1];

        //시작정점과 도착정점이 동일한 경우 0, 그 외의 경우는 최대값으로 초기화
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                if(i==j) continue;
                adjMatrix[i][j] = 10000000;
            }
        }

        //출발 도시, 도착 도시, 비용 입력받아서 인접행렬에 저장
        StringTokenizer st;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            //출발 도시와 도착 도시를 연결하는 버스 여러개일 수 있으므로 그 중 최소값 저장
            adjMatrix[r][c] = Math.min(adjMatrix[r][c],cost);
        }

        //플로이드 워셜
        for(int k=1; k<n+1; k++){//경유지
            for(int i=1; i<n+1; i++){//출발 도시
                if(i==k) continue;
                for(int j=1; j<n+1; j++){//도착 도시
                    if(i==j || j==k) continue;
                    //i에서 j로 가는 경우의 최소비용과 k를 경유해서 i->k->j로 가는 경우의 비용 비교해서 최소값 갱신
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k]+adjMatrix[k][j]);
                }
            }
        }

        //출력
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                //i에서 j로 갈 수 없는 경우 0 출력
                if(adjMatrix[i][j]==10000000) sb.append(0).append(" ");
                else sb.append(adjMatrix[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}