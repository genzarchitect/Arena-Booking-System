package com.shamon.service;

import com.shamon.Exceptions.EmailNotFound;
import com.shamon.Exceptions.IncorrectPasswordException;
import com.shamon.Exceptions.UserExistsException;
import com.shamon.Exceptions.UserNotFoundException;

import com.shamon.model.User;

public interface LoginService {

    User registerUser(User user)throws UserExistsException;
    User authenticateUser(String email,String password) throws UserNotFoundException, IncorrectPasswordException;
    User getUser(String email) throws UserNotFoundException;
    User forgotPassword(String email,User user)throws EmailNotFound;


}
