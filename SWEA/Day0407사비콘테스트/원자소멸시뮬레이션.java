package Day0407������׽�Ʈ;

import java.util.ArrayList;
import java.util.Scanner;

public class ���ڼҸ�ùķ��̼� {

	//���
	static int N, sum;
	static int[] arr;
	static ArrayList<Atom> list;
	static boolean[] check;
	
	static class Atom{
		//x��ǥ, y��ǥ, ����, ����������
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
			N = sc.nextInt();//���� ��
			
			//���� ���� ����Ʈ�� ����
			int id = 0;
			list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				list.add(new Atom(id++,sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()));
			}

			sum = 0;//���� ������ �� ��
			check = new boolean[N];
			simulation();
			
			System.out.println("#"+tc+" "+sum);
		}//tc

	}

	private static void simulation() {
		//�̵� ������ �ݴ���� ������ 3�� Ž���ؼ� ���� �� �ִ� ���� ã��
		for(Atom a:list) {
			if(check[a.id]) continue;//�Ҹ��� ���Ҹ� �ǳʶٱ�
			
			int x = a.x;
			int y = a.y;
			int d = a.d;
			
			int[] arr = new int[3];//0:���� ���� ������ �ð�, 1:�׶� ������ ���� ��ȣ, 2:������ ���� ������
			arr[0] = 2222;
			
			for(Atom b:list) {
				//�� �ڽ��̸� �ǳʶٱ�
				if(a.id==b.id) continue;
				
				//1.���� x��ǥ���� ���ֺ��� ���ų� ���� y��ǥ���� ���ֺ��� ���� ���� �ִ� ���
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
					
				//2. x��ǥ�� �� == y��ǥ�� �� �̸鼭 90�� �������� ���� ���ڰ� �ִ� ���
				}else if(x-b.x==y-b.y && ((d==2 && b.d==0)||(d==1 && b.d==3))) {
					//���Ͽ� �ִ� ���ڶ� ������ ���
					if(arr[0]>x-b.x) {
						arr[0] = x-b.x;
						arr[1] = b.id;
						arr[2] = b.k;
					}
				}else if(x-b.x==b.y-y &&((d==0&&b.d==3)||(d==2&&b.d==1))) {
					//�»� �ִ� ���ڶ� ������ ���
					if(arr[0]>x-b.x) {
						arr[0] = x-b.x;
						arr[1] = b.id;
						arr[2] = b.k;
					}
				}else if(b.x-x==y-b.y &&((d==1&&b.d==2)||(d==3&&b.d==0))) {
					//���Ͽ� �ִ� ���ڶ� ������ ���
					if(arr[0]>x-b.x) {
						arr[0] = b.x-x;
						arr[1] = b.id;
						arr[2] = b.k;
					}
				}else if(b.x-x==b.y-y &&((d==3&&b.d==1)||(d==0&&b.d==2))) {
					//��� �ִ� ���ڶ� ������ ���
					if(arr[0]>x-b.x) {
						arr[0] = b.x-x;
						arr[1] = b.id;
						arr[2] = b.k;
					}
				}
			}
			//arr[0]�� 2222���� ������ ������ ���� �ִ� �� >> ������ ���� �����ϰ� ������ ������	
			if(arr[0]<2222) {
				sum += (a.k+arr[2]);
				//for�� ���鼭 id�� arr[1]�� ���� �Ҹ� üũ
				check[arr[1]] = true;
			}
			//for�� ���鼭 id�� a.id�� ���� �Ҹ� üũ
			check[a.id] = true;
		}
		
	}

}
