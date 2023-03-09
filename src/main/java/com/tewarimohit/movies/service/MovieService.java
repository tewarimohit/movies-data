package com.tewarimohit.movies.service;

import com.tewarimohit.movies.Movie;
import com.tewarimohit.movies.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    // id might not be there so we will use Optional to return null for such a case.
//    public Optional<Movie> onlyOneMovie(ObjectId id){
//        return movieRepository.findById(id);
//    }

    // by imdbId

    public Optional<Movie> onlyOneMovie(String imdbId){
        return movieRepository.findByImdbId(imdbId);
    }

}
