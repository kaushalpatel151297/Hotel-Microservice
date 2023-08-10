package com.userservice.Client;
import com.userservice.Model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//this is the syncronous microservice..
//where hotel mciroservice can accessable by user microservices.
@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/api/v1/hotel/{hotelid}")
    Hotel getHotel(@PathVariable String hotelid);

}
