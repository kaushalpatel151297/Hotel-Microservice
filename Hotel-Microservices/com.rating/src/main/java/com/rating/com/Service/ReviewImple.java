package com.rating.com.Service;

import com.rating.com.Model.Review;
import com.rating.com.Reposiotry.ReviewReposiotry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewImple implements ReviewService {

    public final ReviewReposiotry reviewReposiotry;

    public ReviewImple(ReviewReposiotry reviewReposiotry) {
        this.reviewReposiotry = reviewReposiotry;
    }

    @Override
    public Review createReview(Review review) {
        String uuid = UUID.randomUUID().toString();
        review.setRatingId(uuid);
        Review savedReviwe = this.reviewReposiotry.save(review);
        return savedReviwe;
    }

    @Override
    public Review updateReview(Review review, String reviewId) {
        Review findbyId = this.reviewReposiotry.findById(reviewId).get();
        findbyId.setUserId(review.getUserId());
        findbyId.setFeedback(review.getFeedback());
        findbyId.setHotelid(review.getHotelid());
        findbyId.setRating(review.getRating());
        Review updatedReview = this.reviewReposiotry.save(findbyId);
        return updatedReview;
    }

    @Override
    public Review getReview(String reviewId) {
        Review byId = this.reviewReposiotry.findById(reviewId).get();
        return byId;
    }

    @Override
    public List<Review> getAllReviews() {
        List<Review> all = this.reviewReposiotry.findAll();
        return all;
    }

    @Override
    public void deleteReview(String reviewId) {
    this.reviewReposiotry.deleteById(reviewId);
    }

    @Override
    public List<Review> getReviewsByUserId(String userId) {
        List<Review> byUserId = this.reviewReposiotry.findByUserId(userId);
        return byUserId;
    }

    @Override
    public List<Review> getReviewsByHotelId(String hotelid) {
        List<Review> byHotelId = this.reviewReposiotry.findByHotelid(hotelid);
        return byHotelId;
    }
}
