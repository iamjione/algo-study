package Day0407사비콘테스트;

import java.util.ArrayList;
import java.util.Scanner;

public class 원자소멸시뮬레이션 {

	//골드
	static int N, sum;
	static int[] arr;
	static ArrayList<Atom> list;
	static boolean[] check;
	
	static class Atom{
		//x좌표, y좌표, 방향, 보유에너지
		int id,x,y,d,k;

		public Atom(int id,int x, int y, int d, int k) {
			this.id=id;
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
			
			//원자 정보 리스트에 저장
			int id = 0;
			list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				list.add(new Atom(id++,sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()));
			}

			sum = 0;//방출 에너지 총 합
			check = new boolean[N];
			simulation();
			
			System.out.println("#"+tc+" "+sum);
		}//tc

	}

	private static void simulation() {
		//이동 방향의 반대방향 제외한 3방 탐색해서 만날 수 있는 원자 찾기
		for(Atom a:list) {
			if(check[a.id]) continue;//소멸한 원소면 건너뛰기
			
			int x = a.x;
			int y = a.y;
			int d = a.d;
			
			int[] arr = new int[3];//0:가장 빨리 만나는 시간, 1:그때 만나는 원자 번호, 2:원자의 보유 에너지
			arr[0] = 2222;
			
			for(Atom b:list) {
				//나 자신이면 건너뛰기
				if(a.id==b.id) continue;
				
				//1.같은 x좌표에서 마주보며 오거나 같은 y좌표에서 마주보며 오는 원자 있는 경우
				if(d==2 && x>b.x && y==b.y && b.d==3) {
					if(arr[0]>(b.y-y)/2) {
						arr[0] = (x-b.x)/2;
						arr[1] = b.id;
						arr[2] = b.k;
					}
				}else if(d==3 && x<b.x && y==b.y && b.d==2) {
					if(arr[0]>(b.y-y)/2) {
						arr[0] = (b.x-x)/2;
						arr[1] = b.id;
						arr[2] = b.k;
					}
				}else if(d==0 && x==b.x && y<b.y && b.d==1) {
					if(arr[0]>(b.y-y)/2) {
						arr[0] = (b.y-y)/2;
						arr[1] = b.id;
						arr[2] = b.k;
					}
				}else if(d==1 && x==b.x && y>b.y && b.d==0) {
					if(arr[0]>(b.y-y)/2) {
						arr[0] = (y-b.y)/2;
						arr[1] = b.id;
						arr[2] = b.k;
					}
					
				//2. x좌표의 차 == y좌표의 차 이면서 90도 방향으로 오는 원자가 있는 경우
				}else if(x-b.x==y-b.y && ((d==2 && b.d==0)||(d==1 && b.d==3))) {
					//좌하에 있는 원자랑 만나는 경우
					if(arr[0]>x-b.x) {
						arr[0] = x-b.x;
						arr[1] = b.id;
						arr[2] = b.k;
					}
				}else if(x-b.x==b.y-y &&((d==0&&b.d==3)||(d==2&&b.d==1))) {
					//좌상에 있는 원자랑 만나는 경우
					if(arr[0]>x-b.x) {
						arr[0] = x-b.x;
						arr[1] = b.id;
						arr[2] = b.k;
					}
				}else if(b.x-x==y-b.y &&((d==1&&b.d==2)||(d==3&&b.d==0))) {
					//우하에 있는 원자랑 만나는 경우
					if(arr[0]>x-b.x) {
						arr[0] = b.x-x;
						arr[1] = b.id;
						arr[2] = b.k;
					}
				}else if(b.x-x==b.y-y &&((d==3&&b.d==1)||(d==0&&b.d==2))) {
					//우상에 있는 원자랑 만나는 경우
					if(arr[0]>x-b.x) {
						arr[0] = b.x-x;
						arr[1] = b.id;
						arr[2] = b.k;
					}
				}
			}
			//arr[0]이 2222보다 작으면 만나는 원자 있는 것 >> 만나는 원자 제거하고 에너지 더해줌	
			if(arr[0]<2222) {
				sum += (a.k+arr[2]);
				//for문 돌면서 id가 arr[1]인 원자 소멸 체크
				check[arr[1]] = true;
			}
			//for문 돌면서 id가 a.id인 원자 소멸 체크
			check[a.id] = true;
		}
		
	}

}
