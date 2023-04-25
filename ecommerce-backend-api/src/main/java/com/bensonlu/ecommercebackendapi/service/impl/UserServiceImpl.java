package com.bensonlu.ecommercebackendapi.service.impl;

import com.bensonlu.ecommercebackendapi.dao.UserDao;
import com.bensonlu.ecommercebackendapi.dto.UserLoginRequest;
import com.bensonlu.ecommercebackendapi.dto.UserRegisterRequest;
import com.bensonlu.ecommercebackendapi.model.User;
import com.bensonlu.ecommercebackendapi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {
    private final static Logger log= LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {

        //check email
        User user=userDao.getUserByEmail(userRegisterRequest.getEmail());

        //if email has been used then throw error
        if (user!=null){
            log.warn("The Email {} has been used",userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        }
        //create account
        return userDao.createUser(userRegisterRequest);
    }

    @Override //check the input if same as the database
    public User login(UserLoginRequest userLoginRequest) {
        User user=userDao.getUserByEmail(userLoginRequest.getEmail());

        if (user==null){
            log.warn("the email {} has not been registerd",userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }


        if(user.getPassword().equals(userLoginRequest.getPassword())){
            return user;
        }else{
            log.warn("email {} 's password is not correct",userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }
}
