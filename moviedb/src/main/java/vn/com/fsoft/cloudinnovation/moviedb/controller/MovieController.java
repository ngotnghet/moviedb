package vn.com.fsoft.cloudinnovation.moviedb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import vn.com.fsoft.cloudinnovation.moviedb.entity.Movie;
import vn.com.fsoft.cloudinnovation.moviedb.repository.MovieRepository;

@Slf4j
@Controller
@RequestMapping(value = "/movies")
public class MovieController {
	@Autowired
	private MovieRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Movie> albums() {
		return repository.findAll();
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> add(@RequestBody @Valid Movie album) {
		log.info("Adding album " + album.getId());
		return new ResponseEntity<>(repository.save(album), HttpStatus.OK);
	}

	@RequestMapping(value = "/environment", method = RequestMethod.GET)
	public ResponseEntity<?> getEnvironment(){
		final String value = System.getenv("VCAP_SERVICES");
		return new ResponseEntity<String>("VCAP_SERVICES : " + value , HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> update(@RequestBody @Valid Movie album) {
		log.info("Updating album " + album.getId());
		return new ResponseEntity<>(repository.save(album), HttpStatus.CREATED);
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Movie getById(@PathVariable String id) {
		log.info("Getting album " + id);
		return repository.findOne(id);
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable String id) {
		log.info("Deleting album " + id);
		repository.delete(id);
	}
}