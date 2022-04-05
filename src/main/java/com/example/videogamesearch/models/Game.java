package com.example.videogamesearch.models;

// DO NOT MODIFY THIS CLASS

public class Game {

	private String name;
	private String backgroundImage;
	private Float rating;

	public void setName(String name) { this.name = name; }
	public String getName() { return this.name; }

	public void setBackgroundImage(String backgroundImage) { this.backgroundImage = backgroundImage; }
	public String getBackgroundImage() { return this.backgroundImage; }

	public void setRating(Float rating) { this.rating = rating; }
	public Float getRating() { return this.rating; }

	@Override
	public String toString() {
		return "name: %s, rating: %f, backgroundImage: %s"
				.formatted(name, rating, backgroundImage);
	}
}
