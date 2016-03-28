//package vn.com.fsoft.cloudinnovation.moviedb.controller;
//
//import static org.hamcrest.Matchers.is;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
//
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.IntegrationTest;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.mock.http.MockHttpOutputMessage;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.context.WebApplicationContext;
//
//import vn.com.fsoft.cloudinnovation.moviedb.MovieDBApplication;
//import vn.com.fsoft.cloudinnovation.moviedb.entity.Movie;
//import vn.com.fsoft.cloudinnovation.moviedb.repository.MovieRepository;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = MovieDBApplication.class)
//@WebAppConfiguration
//@IntegrationTest
//public class MovieControllerIntegrationTest {
//	// Run in real context
//	// Call method by RestTemplate, check returned json
//
//	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
//			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
//
//	private MockMvc mockMvc;
//
//	private HttpMessageConverter mappingJackson2HttpMessageConverter;
//
//	private List<Movie> movieList = new ArrayList<>();
//
//	@Autowired
//	private MovieRepository movieRepository;
//
//	@Autowired
//	private WebApplicationContext webApplicationContext;
//
//	@Autowired
//	void setConverters(HttpMessageConverter<?>[] converters) {
//
//		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
//				.filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();
//
//		Assert.assertNotNull("the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
//	}
//	
//	@Before
//    public void setup() throws Exception {
//        this.mockMvc = webAppContextSetup(webApplicationContext).build();
//        this.movieRepository.deleteAll();
//        this.movieList.add(movieRepository.save(new Movie("Star Wars: The Force Awakens", "J.J. Abrams", "2015", "Adventure")));
//        this.movieList.add(movieRepository.save(new Movie("The Revenant", "Alejandro González Iñárritu", "2015", "Adventure")));
//    }
//
//	@Test
//    public void getSingleMovieTest() throws Exception {
//        mockMvc.perform(get("/movies/"+ this.movieList.get(0).getId()))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(contentType))
//                .andExpect(jsonPath("$.title", is("Star Wars: The Force Awakens")))
//                .andExpect(jsonPath("$.artist", is("J.J. Abrams")))
//                .andExpect(jsonPath("$.releaseYear", is("2015")))
//                .andExpect(jsonPath("$.genre", is("Adventure")));
//    }
//	
//	@Test
//	public void getAllMovieTest() throws Exception {
//		mockMvc.perform(get("/movies"))
//				.andExpect(status().isOk())
//				.andExpect(content().contentType(contentType))
//				.andExpect(jsonPath("$[0].title", is("Star Wars: The Force Awakens")))
//				.andExpect(jsonPath("$[0].artist", is("J.J. Abrams")))
//				.andExpect(jsonPath("$[0].releaseYear", is("2015")))
//                .andExpect(jsonPath("$[0].genre", is("Adventure")))
//                .andExpect(jsonPath("$[1].title", is("The Revenant")))
//				.andExpect(jsonPath("$[1].artist", is("Alejandro González Iñárritu")))
//				.andExpect(jsonPath("$[1].releaseYear", is("2015")))
//                .andExpect(jsonPath("$[1].genre", is("Adventure")));
//	}
//	
//	@Test
//	public void createMovieTest() throws Exception{
//		String movieJson = json(new Movie("Million Dollar Arm", "Craig Gillespie", "2014", " Biography, Drama, Sport "));
//		this.mockMvc.perform(post("/movies")
//					.contentType(contentType)
//					.content(movieJson))
//					.andExpect(status().isCreated());
//	}	
//	
//	@Test
//	public void updateMovieTest() throws Exception{		
//		String movieJson = json(new Movie("Million Dollar Arm", "Craig Gillespie", "2014", " Biography, Drama, Sport "));
//		this.mockMvc.perform(put("/movies")
//					.contentType(contentType)
//					.content(movieJson))
//					.andExpect(status().isOk());
//	}
//	
//	protected String json(Object o) throws IOException {
//        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
//        this.mappingJackson2HttpMessageConverter.write(
//                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
//        return mockHttpOutputMessage.getBodyAsString();
//    }
//	
//}
