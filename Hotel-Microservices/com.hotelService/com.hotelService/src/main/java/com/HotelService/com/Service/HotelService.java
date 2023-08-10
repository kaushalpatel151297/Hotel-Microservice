package com.HotelService.com.Service;

import com.HotelService.com.Model.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

    public Hotel createHotel(Hotel hotel);

    public Hotel updateHotel(Hotel hotel,String hotelid);

    public Hotel getHotel(String hotelid);

    public List<Hotel> getAllHotel();

    public void deleteHotel(String hotelid);
}
