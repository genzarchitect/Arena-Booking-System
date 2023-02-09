package com.shamon.bookingservice.repository;

import com.shamon.bookingservice.model.Booking;
import com.shamon.bookingservice.model.Slot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface SlotRepo extends MongoRepository<Slot,Integer> {
    Optional<Slot> findBySlotDate(String slotDate);
    List<Slot> findByGroundIdAndSlotDate(String groundId, String slotDate);
    Optional<Slot> findById(int slotId);

    Slot findBySlotId(String id);

}
