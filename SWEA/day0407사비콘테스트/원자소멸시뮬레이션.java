import java.util.Scanner;
/*
*
*시간 날 때 다시 풀어보기
*
*/
public class Solution {
 
    static int N, sum;
    static Atom[]  arr;
    static boolean[] extinction;
     
    static class Atom{
        //x좌표, y좌표, 방향, 보유에너지
        int x,y,d,k;
 
        public Atom(int x, int y, int d, int k) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.k = k;
        }
    }
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            N = sc.nextInt();//원자 수
            
            //원자 정보 배열에 저장
            arr = new Atom[N];
            for(int i=0; i<N; i++) {
                arr[i]=new Atom(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
            }
 
            sum = 0;//방출 에너지 총 합
            extinction = new boolean[N];//소멸 체크
            simulation();
             
            System.out.println(&quot;#&quot;+tc+&quot; &quot;+sum);
        }//tc
 
    }
 
    private static void simulation() {
        //이동 방향의 반대방향 제외한 3방 탐색해서 만날 수 있는 원자 찾기
        for(int i=0; i<N; i++) {
            int x = arr[i].x;
            int y = arr[i].y;
            int d = arr[i].d;
            
            double time = 2001;//만나는데 걸리는 시간 (최대 2000초 걸릴 수 있으니까 2001로 초기화)
            int num = 0;//소멸하는 원자 번호
 
            for(int j=i; j<N; j++) {
            	if(extinction[j]) continue;//소멸한 원자면 컨티뉴
            	
                //1.같은 x좌표에서 마주보며 오거나 같은 y좌표에서 마주보며 오는 원자 있는 경우
                if(d==2 && arr[j].d==3 && x>arr[j].x && y==arr[j].y) {
                    if(time>(x-arr[j].x)/2) {
                        time = (x-arr[j].x)/2;
                        num = j;
                    }
                }else if(d==3 && arr[j].d==2 && x<arr[j].x && y==arr[j].y) {
                    if(time>(arr[j].x-x)/2) {
                    	time = (arr[j].x-x)/2;
                        num = j;
                    }
                }else if(d==0 && arr[j].d==1 && x==arr[j].x && y<arr[j].y) {
                    if(time>(arr[j].y-y)/2) {
                    	time = (arr[j].y-y)/2;
                        num = j;
                    }
                }else if(d==1 && arr[j].d==0 && x==arr[j].x && y>arr[j].y) {
                    if(time>(y-arr[j].y)/2) {
                    	time = (y-arr[j].y)/2;
                        num = j;
                    }
                     
                //2. x좌표의 차 == y좌표의 차 이면서 90도 방향으로 오는 원자가 있는 경우
                }else if(x-arr[j].x==y-arr[j].y && ((d==2 && arr[j].d==0)||(d==1 && arr[j].d==3))) {
                    //좌하에 있는 원자랑 만나는 경우
                    if(time>x-arr[j].x) {
                    	time = x-arr[j].x;
                        num = j;
                    }
                }else if(x-arr[j].x==arr[j].y-y &&((d==0&&arr[j].d==3)||(d==2&&arr[j].d==1))) {
                    //좌상에 있는 원자랑 만나는 경우
                    if(time >x-arr[j].x) {
                    	time = x-arr[j].x;
                        num = j;
                    }
                }else if(arr[j].x-x==y-arr[j].y &&((d==1&&arr[j].d==2)||(d==3&&arr[j].d==0))) {
                    //우하에 있는 원자랑 만나는 경우
                    if(time>x-arr[j].x) {
                    	time = arr[j].x-x;
                        num = j;
                    }
                }else if(arr[j].x-x==arr[j].y-y &&((d==3&&arr[j].d==1)||(d==0&&arr[j].d==2))) {
                    //우상에 있는 원자랑 만나는 경우
                    if(time>x-arr[j].x) {
                    	time = arr[j].x-x;
                        num = j;
                    }
                }
            }
            //time이 2001보다 작으면 만나는 원자 있는 것 >> 만나는 원자 소멸체크하고 에너지 더해줌   
            if(time<2001) {
            	extinction[num] = true;//소멸
                sum += (arr[i].k+arr[num].k);//방출 에너지 sum에 더해줌
            }
        }
         
    }
 
}
