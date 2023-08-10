package com.userservice.Client;

import com.userservice.Model.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "RATING-SERVICE")
public interface ReviewService {

    @GetMapping("/review/{ratingId}")
    Review getReview(@PathVariable("ratingId") String ratingId);

    @PostMapping("/api/v1/review/")
    public Review createreview(@RequestBody Review review);
}
