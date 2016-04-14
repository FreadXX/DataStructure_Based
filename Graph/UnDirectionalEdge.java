package com.lsmaker.Graph;

public class UnDirectionalEdge {
	int vertex_one;
	int vertex_two;
	
	int cost;
	
	public UnDirectionalEdge(int v1, int v2, int cost) {
		vertex_one = v1;
		vertex_two = v2;
		this.cost = cost;
	}

	public int getVertex_one() {
		return vertex_one;
	}

	public void setVertex_one(int vertex_one) {
		this.vertex_one = vertex_one;
	}

	public int getVertex_two() {
		return vertex_two;
	}

	public void setVertex_two(int vertex_two) {
		this.vertex_two = vertex_two;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
}
