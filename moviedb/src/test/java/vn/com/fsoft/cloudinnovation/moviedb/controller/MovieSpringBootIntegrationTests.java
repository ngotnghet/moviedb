//package vn.com.fsoft.cloudinnovation.moviedb.controller;
//
//import static org.hamcrest.Matchers.containsString;
//import static org.junit.Assert.assertThat;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.boot.test.TestRestTemplate;
//import org.springframework.boot.test.WebIntegrationTest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.context.WebApplicationContext;
//
//import vn.com.fsoft.cloudinnovation.moviedb.MovieDBApplication;
//import vn.com.fsoft.cloudinnovation.moviedb.entity.Movie;
//import vn.com.fsoft.cloudinnovation.moviedb.repository.MovieRepository;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(MovieDBApplication.class)
//@WebIntegrationTest({ "server.port=0", "management.port=0" })
//public class MovieSpringBootIntegrationTests {
//
//	private MockMvc mockMvc;
//	private List<Movie> movieList = new ArrayList<>();
//
//	@Autowired
//	private MovieRepository movieRepository;
//
//	@Autowired
//	private WebApplicationContext webApplicationContext;
//
//	RestTemplate rest = new TestRestTemplate();
//	@Value("${local.server.port}")
//	int port;
//
//	private String getBaseUrl() {
//		return "http://localhost:" + port + "/movies/";
//	}
//
//	@Before
//	public void setup() throws Exception {
//		this.mockMvc = webAppContextSetup(webApplicationContext).build();
//		this.movieRepository.deleteAll();
//		this.movieList.add(
//				movieRepository.save(new Movie("Star Wars: The Force Awakens", "J.J. Abrams", "2015", "Adventure")));
//		this.movieList.add(
//				movieRepository.save(new Movie("The Revenant", "Alejandro González Iñárritu", "2015", "Adventure")));
//	}
//
//	@Test
//	public void getMovieObjectTest() {
//		ResponseEntity<Movie> movie = rest.getForEntity(getBaseUrl() + this.movieList.get(0).getId(), Movie.class);
//		assertThat(movie.getBody().getTitle(), containsString("Star Wars: The Force Awakens"));
//		assertThat(movie.getBody().getArtist(), containsString("J.J. Abrams"));
//		assertThat(movie.getBody().getReleaseYear(), containsString("2015"));
//		assertThat(movie.getBody().getGenre(), containsString("Adventure"));
//	}
//	
//	@Test 
//	public void getMovieListTest(){
//		ResponseEntity<Movie[]> movieList = rest.getForEntity(getBaseUrl(), Movie[].class);
//		assertThat(movieList.getBody()[0].getTitle(), containsString("Star Wars: The Force Awakens"));
//		assertThat(movieList.getBody()[0].getArtist(), containsString("J.J. Abrams"));
//		assertThat(movieList.getBody()[0].getReleaseYear(), containsString("2015"));
//		assertThat(movieList.getBody()[0].getGenre(), containsString("Adventure"));
//		assertThat(movieList.getBody()[1].getTitle(), containsString("The Revenant"));
//		assertThat(movieList.getBody()[1].getArtist(), containsString("Alejandro González Iñárritu"));
//		assertThat(movieList.getBody()[1].getReleaseYear(), containsString("2015"));
//		assertThat(movieList.getBody()[1].getGenre(), containsString("Adventure"));
//	}
//	
//	@Test 
//	public void addMovieTest(){
//		Movie movie = new Movie("No Country for Old Men  ", "Ethan Coen, Joel Coen ", "2007", "Crime, Drama, Thriller");
//		Movie movieReturn = rest.postForObject(getBaseUrl(), movie, Movie.class);
//		
//		//test entity response
//		ResponseEntity<Movie[]> movieList = rest.getForEntity(getBaseUrl(), Movie[].class);
//		assertThat(movieList.getBody()[2].getTitle(), containsString(movieReturn.getTitle()));
//		assertThat(movieList.getBody()[2].getArtist(), containsString(movieReturn.getArtist()));
//		assertThat(movieList.getBody()[2].getReleaseYear(), containsString(movieReturn.getReleaseYear()));
//		assertThat(movieList.getBody()[2].getGenre(), containsString(movieReturn.getGenre()));
//	}	
//}
