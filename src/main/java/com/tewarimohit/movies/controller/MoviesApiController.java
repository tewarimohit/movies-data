package com.tewarimohit.movies.controller;

import com.tewarimohit.movies.Movie;
import com.tewarimohit.movies.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesApiController {
@Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    // by ObjectId
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id){
//
//     return new ResponseEntity<Optional<Movie>>(movieService.onlyOneMovie(id),HttpStatus.OK);
//    }

    //by ImdbId
    @GetMapping("/{imdbId}")
        public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){

     return new ResponseEntity<Optional<Movie>>(movieService.onlyOneMovie(imdbId),HttpStatus.OK);
    }

}
