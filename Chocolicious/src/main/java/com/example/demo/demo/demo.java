package com.example.demo.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="chocolicious")
public class demo {
      @Id	
		//@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="PositionNo")
		private int position;
	    @Column(name="ChocolateName")
		private String chocolatename;
	    @Column(name="ChocolateRating")
		private int rating;
	    @Column(name="ChocolateBrand")
		private String brand;
		public int getPosition() {
			return position;
		}
		public void setPosition(int position) {
			this.position = position;
		}
		public String getChocolatename() {
			return chocolatename;
		}
		public void setChocolatename(String chocolatename) {
			this.chocolatename = chocolatename;
		}
		public int getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public demo(int position, String chocolatename, int rating, String brand) {
			super();
			this.position = position;
			this.chocolatename = chocolatename;
			this.rating = rating;
			this.brand = brand;
		}
		public demo() {
			
		}
		
	

	}



