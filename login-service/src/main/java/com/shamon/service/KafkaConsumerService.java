package com.shamon.service;

import com.shamon.model.User;
import com.shamon.userDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @Autowired
    private LoginService loginService;
    @KafkaListener(topics = "game",groupId = "Group1",containerFactory = "dtoListener")
    public void listen(UserDTO dto)
    {

        System.out.println("Received"+dto);
        System.out.println("Received"+dto);
        System.out.println("Received"+dto);
        System.out.println("Received"+dto);
        System.out.println("Received"+dto);
        System.out.println("Received"+dto);
        System.out.println("Received"+dto);
        System.out.println("Received"+dto);
        System.out.println("Received"+dto);

        User user=new User(dto.getUserEmail(), dto.getUserPassword(),dto.getUserType());
        loginService.registerUser(user);
    }
}
