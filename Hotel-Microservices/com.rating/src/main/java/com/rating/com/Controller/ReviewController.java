package com.rating.com.Controller;

import com.rating.com.Model.Review;
import com.rating.com.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/review")
public class ReviewController{

    @Autowired
    private ReviewService reviewservice;

    @PostMapping("/")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review review1 = this.reviewservice.createReview(review);
        return ResponseEntity.status(HttpStatus.CREATED).body(review1);
    }

    @GetMapping("{ratingId}")
    public ResponseEntity<Review> getReview(@PathVariable String ratingId) {
        Review getReview = this.reviewservice.getReview(ratingId);
        return ResponseEntity.status(HttpStatus.OK).body(getReview);
    }

    @GetMapping("/allreviews")
    public ResponseEntity<List<Review>> getALlReview() {
        List<Review> allReviews = this.reviewservice.getAllReviews();
        return ResponseEntity.status(HttpStatus.OK).body(allReviews);
    }

    @PutMapping("/update/{reviewId}")
    public ResponseEntity<Review> updateReview(@RequestBody Review review, @PathVariable String reviewId) {
        Review review1 = this.reviewservice.updateReview(review, reviewId);
        return ResponseEntity.status(HttpStatus.OK).body(review1);
    }

    @DeleteMapping("/delete/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable String reviewId) {
        this.reviewservice.deleteReview(reviewId);
        return ResponseEntity.status(HttpStatus.OK).body("REVIEW IS DELETED!");
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Review>> getReviewUser(@PathVariable String userId) {
        List<Review> reviewsByUserId = this.reviewservice.getReviewsByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(reviewsByUserId);
    }

    @GetMapping("/hotels/{hotelid}")
    public ResponseEntity<List<Review>> getReviewHotels(@PathVariable String hotelid)
    {
        List<Review> reviewsByHotelId = this.reviewservice.getReviewsByHotelId(hotelid);
        return ResponseEntity.status(HttpStatus.OK).body(reviewsByHotelId);
    }

}
