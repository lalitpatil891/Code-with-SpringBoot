package com.nit.sbeans;

public class Cricket {

		private String title;
		private Batter batter;
		private Boller boller;
		
		//Constructor Injection 
		public Cricket(String title, Batter batter, Boller boller) {
			this.title = title;
			this.batter = batter;
			this.boller = boller;
		}
		
		public void displayScore() {
			
			System.out.println("Title: "+title);
			batter.displayBatter();
			boller.displayBoller();
		}
}
