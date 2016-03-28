package vn.com.fsoft.cloudinnovation.moviedb.repository;

import org.springframework.data.repository.CrudRepository;

import vn.com.fsoft.cloudinnovation.moviedb.entity.Movie;

public interface MovieRepository extends CrudRepository<Movie, String> {
}
