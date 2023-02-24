package IM대비;

import java.util.Scanner;

public class 정곤이의단조증가하는수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int ans = -1;
			
			for(int i=0; i<N-1; i++) {
				label:
				for(int j=i+1; j<N; j++) {
					String num = Integer.toString(arr[i]*arr[j]);
					//곱한 값이 한자리수인 경우 다른 조건 필요 없이 그냥 단조증가함수!
					if(num.length()==1) {
						ans = arr[i]*arr[j];
						break;
					}
					//곱한 값이 두자리수 이상인 경우
					for(int k=0; k<num.length()-1; k++) {
						if((int)num.charAt(k)-(int)num.charAt(k+1)>0) {
							continue label;//앞에 수가 더 크면 단조증가함수 아님
						}
					}
					if(arr[i]*arr[j]>ans) ans = arr[i]*arr[j];
				}
			}	
			System.out.println("#"+tc+" "+ans);
		}
	}
}
