package com.shamon.service;


import com.shamon.model.UserCredential;

import java.util.Map;

public interface TokenGeneratorService {

    Map<String,String> generateToken(UserCredential credential);
}
