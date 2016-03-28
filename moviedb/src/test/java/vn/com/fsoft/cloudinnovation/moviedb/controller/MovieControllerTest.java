//package vn.com.fsoft.cloudinnovation.moviedb.controller;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import com.google.common.collect.Lists;
//
//import vn.com.fsoft.cloudinnovation.moviedb.MovieDBApplication;
//import vn.com.fsoft.cloudinnovation.moviedb.entity.Movie;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = MovieDBApplication.class)
//@WebAppConfiguration
//public class MovieControllerTest {
//
//	@Autowired
//	private MovieController controller;
//
//	@Test
//	public void testExistUser() {
//		Iterable<Movie> albums = controller.albums();
//		assertEquals("Movie list must contains 52 record ", 52, Lists.newArrayList(albums).size());
//	}
//
//	@Test
//	public void testFindExistUser() {
//		assertEquals("Result must contains 1 record", 1, Lists.newArrayList(controller.getById("5F076952-3988-4DD7-8A91-4F1766E07822")).size());
//	}
//
//}
