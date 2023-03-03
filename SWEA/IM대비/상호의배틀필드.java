package IM대비;

import java.util.Scanner;

public class 상호의배틀필드 {

	//H, W: 배열 크기
	//r, c: 현재 전차 위치
	static int H, W, r, c;
	static char[][] arr;//맵 입력받을 배열
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			arr = new char[H][W];
			
			//맵 정보 입력받기 && 전차 현재 위치 찾기
			for(int i=0; i<H; i++) {
				String s = sc.next();
				for(int j=0; j<W; j++) {
					arr[i][j] = s.charAt(j);
					if(arr[i][j]=='^'||arr[i][j]=='v'||arr[i][j]=='<'||arr[i][j]=='>') {
						r = i;//전차의 현재 위치 행
						c = j;//전차의 현재 위치 열
					}
				}
			}
			
			int N = sc.nextInt();//입력의 개수
			String input = sc.next();
			for(int i=0; i<N; i++) {
				char cmd = input.charAt(i);
				if(cmd == 'S') shoot();
				else move(cmd);
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
	}

	
	private static void move(char cmd) {
		//명령에 맞는 상하좌우 델타 인덱스값 && 전차 모양
		int idx = 0;//U
		char tank = '^';
		switch(cmd) {
		case 'D':
			idx = 1;
			tank = 'v';
			break;
		case 'L':
			idx = 2;
			tank = '<';
			break;
		case 'R':
			idx = 3;
			tank = '>';
		}
		
		int nr = r+dr[idx];
		int nc = c+dc[idx];
		//이동하려는 곳이 평지면 이동하고 원래 있던 곳 평지로!
		if(nr>=0 && nr<H && nc>=0 && nc<W && arr[nr][nc]=='.') {
			arr[nr][nc] =tank;
			arr[r][c] = '.';
			r = nr;
			c = nc;
		}else {
			//이동하려는 곳으로 갈 수 없으면 전차 방향만 돌림
			arr[r][c] = tank;
		}
		
	}

	private static void shoot() {
		//상하좌우에 맞는 델타 인덱스값 찾기
		int idx = 0;
		switch(arr[r][c]) {
		case 'v':
			idx = 1;
			break;
		case '<':
			idx = 2;
			break;
		case '>':
			idx = 3;
		}
		
		int nr = r+dr[idx];
		int nc = c+dc[idx];
		//범위 내에 있는 동안
		while(nr>=0 && nr<H && nc>=0 && nc<W) {
			if(arr[nr][nc]=='*') {//벽돌 벽을 만나면 평지로 만들고 포탄 소멸
				arr[nr][nc]='.';
				break;
			}else if(arr[nr][nc]=='#') {//강철벽 만나면 포탄 소멸
				break;
			}
			nr += dr[idx];
			nc += dc[idx];
		}
	}


}
