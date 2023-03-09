package com.tewarimohit.movies.service;

import com.tewarimohit.movies.Movie;
import com.tewarimohit.movies.Reviews;
import com.tewarimohit.movies.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    // to talk to db for dynamic queries without repository we need template
    @Autowired
    private MongoTemplate mongoTemplate;
public Reviews createReview(String body, String imdbId){
    Reviews review= reviewRepository.insert(new Reviews(body));
    mongoTemplate.update(Movie.class)
            .matching(Criteria.where("imdbId").is(imdbId))
            .apply(new Update().push("reviewIds").value(review))
            .first();
    return review;
}
}
