package com.nit.sbeans;

public class Batter {

	private String batterName;
	private int score;
	
	public Batter() {
		System.out.println("Batter Is playing now");
	}
	
	//Setter Injection
	public void setScore(int score) {
		this.score = score;
	}
	
	public void setBatterName(String batterName) {
		this.batterName = batterName;
	}
	
	public void displayBatter() {
		System.out.println("Batter Name: "+batterName);
		System.out.println("Batter Score: "+score);
	}
}
