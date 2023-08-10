package com.rating.com.Service;

import com.rating.com.Model.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

     Review createReview(Review review);

     Review updateReview(Review review,String reviewId);

     Review getReview(String reviewId);

     List<Review> getAllReviews();

     void deleteReview(String reviewId);

     List<Review> getReviewsByUserId(String userId);

     List<Review> getReviewsByHotelId(String hotelid);
}
