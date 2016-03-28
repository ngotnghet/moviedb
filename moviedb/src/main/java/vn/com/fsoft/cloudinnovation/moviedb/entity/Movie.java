package vn.com.fsoft.cloudinnovation.moviedb.entity;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movie {
	@Id
	@Column(length = 40)
	@GeneratedValue(generator = "randomId")
	@GenericGenerator(name = "randomId", strategy = "vn.com.fsoft.cloudinnovation.moviedb.entity.RandomIdGenerator")
	@Getter
	@Setter
	private String id;

	@Getter
	@Setter
	private String title;

	@Getter
	@Setter
	private String artist;

	@Getter
	@Setter
	public String releaseYear;

	@Getter
	@Setter
	private String genre;

	@Getter
	@Setter
	private Double rating;

	@Getter
	@Setter
	private String poster;
	
	@Getter
	@Setter
	private String duration;

	public Movie() {
	}

	public Movie(String title, String artist, String releaseYear, String genre) {
		this.title = title;
		this.artist = artist;
		this.releaseYear = releaseYear;
		this.genre = genre;
	}
	
}
