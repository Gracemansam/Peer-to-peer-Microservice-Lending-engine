package com.graceman.lendingengine.domain.services;

import com.graceman.lendingengine.domain.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
}
