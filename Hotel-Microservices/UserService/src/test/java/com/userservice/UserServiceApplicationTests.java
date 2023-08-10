package com.userservice;

import com.userservice.Client.ReviewService;
import com.userservice.Model.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
@Service
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private ReviewService reviewService;
	@Test
	void createReview()
	{
		Review rat = Review.builder().ratingId("something").userId("something").feedback("something").rating(2).build();
	this.reviewService.createreview(rat);
		System.out.println("kaushal");
	}


}
