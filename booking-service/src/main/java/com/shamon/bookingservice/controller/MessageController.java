package com.shamon.bookingservice.controller;

import com.shamon.bookingservice.model.Message;
import com.shamon.bookingservice.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class MessageController {
    @Autowired
    private MessageService service;

@PostMapping("/sendmessage")
public String sendMessage(@RequestBody Message message)
{
    service.sendMessage(message);
    System.out.println("Successfully published='" + message +"'message");
    return "Successfully published the animal='" + message +"'message";
}
}