package com.HotelService.com.Reposiotry;

import com.HotelService.com.Model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
//this is the repository file
@Repository
public interface HotelReposiotry extends MongoRepository<Hotel,String>{
}
