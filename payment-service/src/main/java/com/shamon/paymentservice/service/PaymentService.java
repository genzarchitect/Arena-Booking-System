package com.shamon.paymentservice.service;

import com.shamon.paymentservice.model.PaymentDetails;

public interface PaymentService  {
    PaymentDetails saveOnePayment(PaymentDetails paymentDetails);

   // PaymentDetails updateOrderWithBookingId (String orderId, String bookingId);

    PaymentDetails findById(String orderId);
}
