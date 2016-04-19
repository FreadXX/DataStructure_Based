package com.lsmaker.Graph;

public class DirectionalEdge {
	
	int vertex_from;
	int vertex_to;
	
	int cost;
	
	public DirectionalEdge(int v1, int v2, int cost) {
		vertex_from = v1;
		vertex_to = v2;
		this.cost = cost;
	}

	public int getVertex_from() {
		return vertex_from;
	}

	public void setVertex_from(int vertex_from) {
		this.vertex_from = vertex_from;
	}

	public int getVertex_to() {
		return vertex_to;
	}

	public void setVertex_to(int vertex_to) {
		this.vertex_to = vertex_to;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	
	
}
