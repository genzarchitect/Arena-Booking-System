package com.shamon.bookingservice.services;

import com.shamon.bookingservice.config.TaskExecutorConfig;
import com.shamon.bookingservice.exceptions.*;
import com.shamon.bookingservice.model.Booking;
import com.shamon.bookingservice.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    public BookingRepo bookingRepo;

    @Qualifier("taskExecutor")
    @Autowired
    public ThreadPoolTaskExecutor taskExecutor;

    @Async
    public CompletableFuture<List<Booking>> getAllBookingFromRepoAsync() {
        try {
            return CompletableFuture.completedFuture(getAllBookingFromRepo());
        } catch (EmptyBookingList ex) {
            return CompletableFuture.completedFuture(List.of());
        } catch (Exception ex) {
            throw new RuntimeException("Failed to fetch bookings", ex);
        }
    }
    @Override
    public List<Booking> getAllBookingFromRepo() {

        List<Booking> bookings = bookingRepo.findAll();
        if (bookings.size() > 0) {
            return bookings;
        }
        throw new EmptyBookingList("Booking List is Empty");

    }

    @Override
    public Booking addAllBookingToBookingdb(Booking booking) throws BookingAlreadyFound {
        Booking bookings = bookingRepo.findByBookingId(booking.getBookingId());
        if (bookings!=null) {
            throw new BookingAlreadyFound("Booking is added succesfully");
        }

        return this.bookingRepo.save(booking);
    }


    @Override
    public Booking getBookingById(String bookingId) {
        Booking bookings = bookingRepo.findByBookingId(bookingId);
        if (bookings!=null) {
            return bookings;
        }

        throw new BookingIdNotFound("Booking to be deleted not Found");
    }



    @Override
    public List<Booking> getBookingByPlayerEmail(String playerEmail) {
        List<Booking> bookings = bookingRepo.findByEmail(playerEmail);
        if (bookings!=null) {
            return bookings;
        }
        throw new BookingPlayerEmailNotFound("Booking  not Found");


    }

    @Override
    public List<Booking> getBookingByOwnerEmail(String groundOwnerEmail) {
        List<Booking> bookings = bookingRepo.findByOEmail(groundOwnerEmail);
        if (bookings!=null) {
            return bookings;
        }
        throw new BookingOwnerEmailNotFound("Booking to be deleted not Found");
    }
    @Override
    public Booking deleteBookingById(String bookingId) {
        Booking bookings = bookingRepo.findByBookingId(bookingId);
        if (bookings!=null) {
            bookingRepo.delete(bookings);
            return bookings;
        }
        throw new DeleteBookingIdNotFound("Booking to be deleted not Found");
    }

}

