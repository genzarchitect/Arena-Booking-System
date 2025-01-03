package com.shamon.bookingservice.services;

import com.shamon.bookingservice.exceptions.*;
import com.shamon.bookingservice.model.Booking;
import com.shamon.bookingservice.model.Slot;
import com.shamon.bookingservice.repository.BookingRepo;
import com.shamon.bookingservice.repository.SlotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SlotServiceImpl implements SlotService{
    @Autowired
    public SlotRepo slotRepo;

    @Override
    public List<Slot> getAllSlotFromRepo() {
        List<Slot> slots = slotRepo.findAll();
        if (slots.size() > 0) {
            return slots;
        }
        throw new EmptySlotList("Slot List is Empty");

    }

    @Override
    public Slot addAllSlotTobookingdb(Slot slot) throws SlotAlreadyFound {
        Slot slots = slotRepo.findBySlotId(slot.getSlotId());
        if (slots!=null) {
            throw new SlotAlreadyFound("Slot is added succesfully");
        }
        return this.slotRepo.save(slot);
    }

    @Override
    public Slot getSlotById(String slotId) {
       Slot slots = slotRepo.findBySlotId(slotId);
        if (slots!=null) {
            return slots;
        }
        throw new BookingIdNotFound("slot not found");
    }

    @Override
    public Slot bookSlot(String slotId) {
        for (int attempt = 0; attempt < 3; attempt++) {
            try {
                Slot slot = slotRepo.findBySlotId(slotId);
                if (slot == null) {
                    throw new RuntimeException("Slot not found");
                }

                if (slot.getNumberOfPlayers() <= 0) {
                    throw new RuntimeException("Slot is fully booked");
                }
                slot.setNumberOfPlayers(slot.getNumberOfPlayers() - 1);
                return slotRepo.save(slot);

            } catch (OptimisticLockingFailureException e) {
                // Retry on failure
                if (attempt == 2) {
                    throw new RuntimeException("Failed to book slot after multiple attempts. Please try again.");
                }
            }
        }
        throw new RuntimeException("Unexpected error during slot booking");
    }


    @Override
    public Slot getSlotByDate(String slotDate) {
        Optional<Slot> slots = slotRepo.findBySlotDate(slotDate);
        if (slots.isPresent()) {
            Slot slot = slots.get();
            slotRepo.findBySlotDate(slotDate);
            return slot;
        }
        throw new SlotDateNotFound("slot not found");
    }


    @Override
    public List<Slot> getSlotsForGroundByDate(String groundId, String date) {
        return slotRepo.findByGroundIdAndSlotDate(groundId, date);
    }

    @Override
    public Slot updateSlotById(String slotId, Slot updatedslot) {
        Slot slots = slotRepo.findBySlotId(slotId);

        if (slots!=null) {
            slots.setSlotId(updatedslot.getSlotId());
            slots.setStatus(updatedslot.getStatus());
            slots.setSlotDate(updatedslot.getSlotDate());
            slots.setSlotStartTiming(updatedslot.getSlotStartTiming());
            slots.setSlotEndTiming(updatedslot.getSlotEndTiming());
            slots.setNumberOfPlayers(updatedslot.getNumberOfPlayers());
            slotRepo.save(slots);
            return slots;
        }
        throw new UpdateSlotNotFound("Please select the slot to update");
    }



}

