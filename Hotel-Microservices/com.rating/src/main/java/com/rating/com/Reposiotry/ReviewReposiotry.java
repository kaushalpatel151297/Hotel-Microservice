package com.rating.com.Reposiotry;

import com.rating.com.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewReposiotry extends JpaRepository<Review,String> {

    List<Review> findByUserId(String userId);

    List<Review> findByHotelid(String hotelid);
}
