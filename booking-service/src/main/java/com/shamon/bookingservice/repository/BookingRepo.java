package com.shamon.bookingservice.repository;

import com.shamon.bookingservice.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepo extends MongoRepository<Booking,Integer> {
    @Query("{ 'playerEmail': ?0 }")
    List<Booking> findByEmail(String playerEmail);
    @Query("{ 'groundOwnerEmail': ?0 }")
    List<Booking> findByOEmail(String groundOwnerEmail);

    Booking findByBookingId(String id);

}
