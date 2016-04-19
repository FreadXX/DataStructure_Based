package com.lsmaker.Graph;

import com.datastructor.Stack_Queue.CirCleSeqQueue;
import com.datastructor.Stack_Queue.Queue;

public class DirectionalGraph {
	private int vertexNumber;			//图中顶点个数
	private int[][] edgeMatrix;			//表示边的邻接矩阵
	
	public DirectionalGraph(int vertexNumber) {
		this.vertexNumber = vertexNumber;
		
		edgeMatrix = new int[vertexNumber][vertexNumber];	//初始化邻接矩阵
		
		for(int i=0;i<vertexNumber;i++) {
			for(int j=0;j<vertexNumber;j++) {
				edgeMatrix[i][j] = 0;
			}
		}
	}
	
	/**
	 * 插入一个顶点，将插入位置的顶点移动对应的边移动到最后一行和最后一列，将新插入的顶点置0
	 * @param vertex	顶点插入的位置
	 */
	public void insertVertex(int vertex) {				
		int index = vertex - 1;
		int[][] newedgeMatrix = new int[vertexNumber+1][vertexNumber+1];
		
		for(int i=0;i<vertexNumber;i++) {
			for(int j=0;j<vertexNumber;j++) {
				newedgeMatrix[i][j] = edgeMatrix[i][j];
			}
		}
		
		for(int i=0;i<vertexNumber;i++) {
			newedgeMatrix[i][vertexNumber] = newedgeMatrix[i][index];	//将index列的所有数据移到vertexNumber列
			newedgeMatrix[vertexNumber][i] = newedgeMatrix[index][i];	//将index行的所有数据移到vertexNumber行
			newedgeMatrix[i][index] = 0;								//将index行的数据置0（此顶点未插入边）
			newedgeMatrix[index][i] = 0;								//将index列的数据置0（此顶点未插入边）
		}
		
		edgeMatrix = newedgeMatrix;
		vertexNumber++;
	}
	
	/**
	 * 删除一个顶点，将最后一个顶点的所有边移到删除顶点的位置，删除最后一行和最后一列
	 * @param vertex
	 */
	public void deleteVertex(int vertex) {
		int index = vertex - 1;
		
		for(int i=0;i<vertexNumber;i++) {
			edgeMatrix[i][index] = edgeMatrix[i][vertexNumber-1];
			edgeMatrix[index][i] = edgeMatrix[vertexNumber-1][i];
		}
		
		int[][] newedgeMatrix = new int[vertexNumber-1][vertexNumber-1];
		
		for(int i=0;i<vertexNumber -1;i++) {
			for(int j=0;j<vertexNumber -1;j++) {
				newedgeMatrix[i][j] = edgeMatrix[i][j];
			}
		}
		
		edgeMatrix = newedgeMatrix;
		vertexNumber--;
	}
	
	/**
	 * 插入一个边
	 * @param edge
	 */
	public void insertEdge(DirectionalEdge edge) {
		int vertex1 = edge.getVertex_from();
		int vertex2 = edge.getVertex_to();
		edgeMatrix[vertex1-1][vertex2-1] = edge.getCost();
	}
	
	/**
	 * 删除一个边
	 * @param edge
	 */
	public void deleteEdge(DirectionalEdge edge) {
		int vertex1 = edge.getVertex_from();
		int vertex2 = edge.getVertex_to();
		edgeMatrix[vertex1-1][vertex2-1] = 0;
	}
	
	public boolean isEmpty() {
		if(vertexNumber == 0) {					//如果图中没有点，那么图为空
			return true;
		}
		for(int i=0;i<vertexNumber;i++) {
			for(int j=0;j<vertexNumber;j++) {
				if(edgeMatrix[i][j] != 0) {
					return false;				//如果图中存在边，那么图不为空
				}
			}
		}
		return true;
	}
	
	public int getFirstNeighborVertex (int vertex) {
		int index = vertex - 1;
		int nextVertex = -1;
		for(int i=0;i<vertexNumber;i++) {
			if(edgeMatrix[index][i] != 0) {
				nextVertex = i+1;
				break;
			}
		}
		return nextVertex;
	}
	
	public int getNextNeighborVertex (int vertex, int next) {
		int index = vertex - 1;
		int nextVertex = -1;
		for(int i=next;i<vertexNumber;i++) {
			if(edgeMatrix[index][i] != 0) {
				nextVertex = i+1;
				break;
			}
		}
		return nextVertex;
	}
	
	public void traverse() {
		System.out.println("In the Graph, there are " + vertexNumber + " vertexs.");
		System.out.println("The Edge Matrix is");
		for(int i=0;i<vertexNumber;i++) {
			for(int j=0;j<vertexNumber;j++) {
				System.out.print(edgeMatrix[i][j] + ",");
			}
			System.out.println();
		}
	}
	
	
	/**
	 * DFS：采用深度优先搜索进行遍历
	 * @return
	 */
	public void DFSTraverse(int vertex) {
		boolean[] visit = new boolean[vertexNumber];
		for(int i=0;i<vertexNumber;i++) {
			for(int j=0;j<vertexNumber;j++) {
				visit[i] = false;
			}
		}
		DFSTraverse(vertex, visit);
		System.out.println("DFS Traverse Finished ...");
	}
	
	public void DFSTraverse(int vertex, boolean[] visit) {
		
		int nextVertex = getFirstNeighborVertex(vertex);
		while(nextVertex != -1) {				//如果该顶点有下一个邻接顶点
			if(visit[nextVertex-1] == false) {	//如果该边未访问
				System.out.println("vertex 1:" + vertex + 	//访问该边
						"vertex 2:" + nextVertex + 
						"cost:" + edgeMatrix[vertex-1][nextVertex-1]);
				visit[nextVertex-1] = true;
				visit[vertex-1] = true;
				DFSTraverse(nextVertex, visit);
			}
			nextVertex = getNextNeighborVertex(vertex, nextVertex);
		}
		
	}
	
	/**
	 * BFS:采用广度优先搜索进行遍历
	 * @param
	 */
	public void BFSTraverse(int vertex) {
		boolean[] visit = new boolean[vertexNumber];
		for(int i=0;i<vertexNumber;i++) {
				visit[i] = false;
		}
		visit[vertex -1] = true;
		Queue<Integer> queue = new CirCleSeqQueue<Integer>();
		queue.enQueue(vertex);
		while(queue.isEmpty() == false) {
			int tempVertex = queue.deQueue();
			int nextTempVertex = getFirstNeighborVertex(tempVertex);
			while(nextTempVertex != -1) {
				if(visit[nextTempVertex-1] == false) {
					System.out.println("vertex 1:" + tempVertex + 	//访问该边
							"vertex 2:" + nextTempVertex + 
							"cost:" + edgeMatrix[vertex-1][nextTempVertex-1]);
					visit[nextTempVertex-1] = true;
					queue.enQueue(nextTempVertex);
				}
				nextTempVertex = getNextNeighborVertex(tempVertex, nextTempVertex);
			}
		}
		System.out.println("BFS Traverse Finished ...");
	}
	
	
	public void ComponentsTraverse() {
		boolean[] visit = new boolean[vertexNumber];
		for(int i=0;i<vertexNumber;i++) {
				visit[i] = false;
		}
		for(int i=0;i<vertexNumber;i++) {
			if(visit[i] == false) {
				DFSTraverse(i+1, visit);
			}
		}
	}
	
	public void ShortestPathwithDijkstra(int vertex) {
		boolean[] S = new boolean[vertexNumber];
		S[vertex - 1] = true;
		int[] dist = new int[vertexNumber];
		dist[vertex - 1] = Integer.MAX_VALUE /2;
		for(int i=0;i<vertexNumber;i++) {		//初始化数组
			if(i != vertex -1) {
				dist[i] = edgeMatrix[vertex-1][i] > 0 ? edgeMatrix[vertex-1][i]:Integer.MAX_VALUE / 2;
				S[i] = false;
			}
		}
		for(int j=0;j<vertexNumber-1;j++) {
			/*寻找dist中的最小值*/
			int min = Integer.MAX_VALUE;
			int index = -1;
			for(int i=0;i<vertexNumber;i++) {
				if(dist[i] < min && S[i] == false) {
					min = dist[i];
					index = i;
				}
			}
			/*将最小值点加入*/
			S[index] = true;
			/*修改dist数组*/
			for(int i=0;i<vertexNumber;i++) {
				int temp = edgeMatrix[index][i];
				if(edgeMatrix[index][i] == 0) {
					temp = Integer.MAX_VALUE / 2;
				}
				int tempValue = dist[index] + temp;
				dist[i] = dist[i] < tempValue ? dist[i]:tempValue;
			}
		}
		
		for(int i=0;i<dist.length;i++) {
			if(i != vertex -1 && dist[i] < Integer.MAX_VALUE / 2) {
				System.out.println("the cost from " + vertex +" to " + (i+1) + ":" + dist[i]);
			}
			
		}
	}
}
