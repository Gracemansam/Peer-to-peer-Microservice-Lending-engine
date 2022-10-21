package com.graceman.lendingengine.domain.services.serviceImpl;

import com.graceman.lendingengine.domain.model.User;
import com.graceman.lendingengine.domain.repository.UserRepository;
import com.graceman.lendingengine.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
