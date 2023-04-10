import java.util.ArrayList;
import java.util.Scanner;
 
public class Solution {
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();//게임판 크기
             
            int[][] arr = new int[N+2][N+2];//게임판 배열
            ArrayList<Wormhole> list = new ArrayList<>();//웜홀 정보 저장할 리스트
             
            for(int i=1; i<N+1; i++) {
                for(int j=1; j<N+1; j++) {
                    //게임판 정보 입력받아서 배열에 저장
                    arr[i][j] = sc.nextInt();
                    //웜홀이면 웜홀 정보 리스트에 저장
                    if(6<=arr[i][j] && arr[i][j]<=10) {
                        list.add(new Wormhole(i,j,arr[i][j]));
                    }
                }
            }
             
            //벽인 부분 5로 저장
            for(int i=0; i<N+2; i++) {
                arr[0][i] = arr[N+1][i] = arr[i][0] = arr[i][N+1] = 5;
            }
             
            //상하좌우 델타값
            int[] dr = {-1,1,0,0};
            int[] dc = {0,0,-1,1};
             
            int ans = 0;//답으로 출력할 최대 점수
             
            //2차원 배열 순회
            int score, nr, nc, dir;
            for(int i=1; i<N+1; i++) {
                for(int j=1; j<N+1; j++) {
                    if(arr[i][j]==0) {//빈공간이라면 게임 시작
                        for(int k=0; k<4; k++) {//시작 방향 상하좌우
                            score = 0;
                            dir = k;//현재 이동 방향
                            nr = i+dr[k];//행
                            nc = j+dc[k];//열
                            boolean end = false;//게임 종료 여부
                             
                            while(true) {
                                //블랙홀,블록,웜홀,벽 만날 때까지 이동
                                while(arr[nr][nc]==0) {
                                    //시작점으로 돌아오면 끝내기
                                    if(nr==i && nc==j) {
                                        end = true;
                                        break;
                                    }
                                    //빈공간이면 다음칸으로 이동
                                    nr += dr[dir];
                                    nc += dc[dir];
                                }
                                 
                                //(nr,nc)가 블랙홀이거나 시작점인 경우
                                if(arr[nr][nc]==-1||end) {
                                    break;
                                }
                                //(nr,nc)가 5인 경우
                                else if(arr[nr][nc]==5) {
                                    score = score*2+1;
                                    break;
                                }
                                //(nr,nc)가 1~4번 블록인 경우
                                else if(1<=arr[nr][nc] && arr[nr][nc]<=4) {
                                    int block = arr[nr][nc];//블록 번호
                                     
                                    if(dir==0) {//위로 이동 중
                                        if(block==2) dir=3;
                                        else if(block==3) dir=2;
                                        else {
                                            score = score*2+1;
                                            break;
                                        }
                                    }else if(dir==1) {//아래로 이동 중
                                        if(block==1) dir=3;
                                        else if(block==4) dir=2;
                                        else {
                                            score = score*2+1;
                                            break;
                                        }
                                    }else if(dir==2) {//왼쪽으로 이동 중
                                        if(block==1) dir=0;
                                        else if(block==2) dir=1;
                                        else {
                                            score = score*2+1;
                                            break;
                                        }
                                    }else {//오른쪽으로 이동 중
                                        if(block==3) dir=1;
                                        else if(block==4) dir=0;
                                        else {
                                            score = score*2+1;
                                            break;
                                        }
                                    }
                                    //블록만나서 90도만큼 방향 바뀐 경우
                                    //점수 올려주고 방향바꿔서 이동
                                    score++;
                                    nr += dr[dir];
                                    nc += dc[dir];
                                }
                                //(nr,nc)가 웜홀인 경우
                                else {
                                    for(Wormhole w:list) {
                                        if(w.n==arr[nr][nc]&&(w.r!=nr || w.c!=nc)) {
                                            nr = w.r+dr[dir];
                                            nc = w.c+dc[dir];
                                            break;
                                        }
                                    }
                                }
                            }
                            //최고점 갱신
                            if(score>ans) ans = score;                           
                        }
                    }
                }
            }   
            System.out.println("#"+tc+" "+ans);
        }//tc
    }
     
    static class Wormhole{
        int r, c, n;//행,열,웜홀번호
 
        public Wormhole(int r, int c, int n) {
            this.r = r;
            this.c = c;
            this.n = n;
        }
    }
 
}
