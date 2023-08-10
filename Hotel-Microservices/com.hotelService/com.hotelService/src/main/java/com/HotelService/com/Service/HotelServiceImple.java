package com.HotelService.com.Service;
import com.HotelService.com.Model.Hotel;
import com.HotelService.com.Reposiotry.HotelReposiotry;
import com.HotelService.com.Service.HotelService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelServiceImple implements HotelService {

    public final HotelReposiotry hotelrepo;

    public HotelServiceImple(HotelReposiotry hotelrepo) {
        this.hotelrepo = hotelrepo;
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        String uuid = UUID.randomUUID().toString();
        hotel.setHotelid(uuid);
        Hotel save = this.hotelrepo.save(hotel);
        return save;
    }

    @Override
    public Hotel updateHotel(Hotel hotel,String hotelid) {
        Optional<Hotel> byId = this.hotelrepo.findById(hotelid);
        Hotel hotel1 = byId.get();
        hotel1.setName(hotel.getName());
        hotel1.setLocation(hotel.getLocation());
        hotel1.setAbout(hotel.getAbout());
        Hotel updatedsaved = hotelrepo.save(hotel1);
        return updatedsaved;
    }

    @Override
    public Hotel getHotel(String hotelid) {
        Hotel gethotel = this.hotelrepo.findById(hotelid).get();
        return gethotel;
    }

    @Override
    public List<Hotel> getAllHotel() {
        List<Hotel> allHotels = this.hotelrepo.findAll();
        return allHotels;
    }

    @Override
    public void deleteHotel(String hotelid) {
        this.hotelrepo.deleteById(hotelid);
    }
}
