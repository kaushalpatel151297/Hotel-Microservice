package com.userservice.Service;

import com.userservice.Client.HotelService;
import com.userservice.Client.ReviewService;
import com.userservice.Model.Hotel;
import com.userservice.Model.Review;
import com.userservice.Model.User;
import com.userservice.Reposiotry.UserReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserImple implements UserService {
    @Autowired
    public  UserReposiotry userReposiotry;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;
    @Autowired
    private ReviewService  reviewService;

//    public UserImple(UserReposiotry userReposiotry) {
//        this.userReposiotry = userReposiotry;
//    }

    @Override
    public User createUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        user.setEmail(user.getEmail());
        return this.userReposiotry.save(user);
    }

    @Override
    public User getUser(String userId) {
        User user = this.userReposiotry.findById(userId).get();


        Review[] forObject = restTemplate.getForObject("http://RATING-SERVICE/api/v1/review/users/" +user.getUserId(), Review[].class);
        List<Review> list = Arrays.stream(forObject).collect(Collectors.toList());
        List<Review> ratinglist = list.stream().map(rating ->
        {
            Hotel hotel = this.hotelService.getHotel(rating.getHotelid());
//            Hotel forObject1 = restTemplate.getForObject("http://HOTEL-SERVICE/api/v1/hotel/"+rating.getHotelid(), Hotel.class);
//            rating.setHotel(forObject1);
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratinglist);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        List<User> all = this.userReposiotry.findAll();
        return all;
    }

    @Override
    public User updateUser(User user, String userId) {
        User byId = this.userReposiotry.findById(userId).get();
        byId.setEmail(user.getEmail());
        byId.setName(user.getName());
        byId.setAbout(user.getAbout());
        User updaetedUser = this.userReposiotry.save(byId);
        return updaetedUser;
    }

    @Override
    public void deleteUser(String userId) {
        this.userReposiotry.deleteById(userId);
    }
}
