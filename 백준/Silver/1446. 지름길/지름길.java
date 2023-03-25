import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//지름길 개수
		int D = Integer.parseInt(st.nextToken());//고속도로 길이
		
		ArrayList<int[]>[] adjList = new ArrayList[D+1];//head가 모두 null인 상태
		for(int i=0; i<D+1; i++) {//비어있는 ArrayList 만들어주기
			adjList[i] = new ArrayList<int[]>();
		}
		
		int[] arr;
		int start, end, d;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr = new int[2];
			start = arr[0] = Integer.parseInt(st.nextToken());//도착점
			end = Integer.parseInt(st.nextToken());//출발점
			d = arr[1] = Integer.parseInt(st.nextToken());//지름길 길이
			//지름길의 도착점이 내 최종 도착점 내에 있고 지름길 타는 것이 그냥 가는거보다 이득인 경우 리스트에 추가
			if(end<=D && end-start>d) {
				adjList[end].add(arr);				
			}
		}
		
		
		int[] distance = new int[D+1];//출발점에서 i까지의 최단 경로
		
		for(int i=1; i<D+1; i++) {
			//지름길 없이 그냥 가면 i까지의 거리는 i-1까지의 거리+1
			distance[i] = distance[i-1]+1;
			
			//i까지 가는 지름길 있는 경우 지름길 타기
			if(adjList[i].size()>0) {
				for(int j=0; j<adjList[i].size(); j++) {
					start = adjList[i].get(j)[0];//i가 도착점인 지름길의 출발점
					d = adjList[i].get(j)[1];//지름길의 거리
					//기존의 거리랑 지름길 탔을 때 거리 비교해서 최단 경로 갱신
					distance[i] = Math.min(distance[i], distance[start]+d);
				}
			}	
		}
		System.out.println(distance[D]);
	}
}