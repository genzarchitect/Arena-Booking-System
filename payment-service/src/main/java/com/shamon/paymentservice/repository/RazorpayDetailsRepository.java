package com.shamon.paymentservice.repository;

import com.shamon.paymentservice.model.PaymentDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RazorpayDetailsRepository extends MongoRepository<PaymentDetails, String> {}
