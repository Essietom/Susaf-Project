package com.univaq.susafProject.service;

import com.univaq.susafProject.model.Dimension;
import com.univaq.susafProject.model.User;
import com.univaq.susafProject.repository.DimensionRepository;
import com.univaq.susafProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUser()
    {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(user1 -> users.add(user1));
        return users;
    }

    public User saveOrUpdateUser(User user )
    {
        return userRepository.save(user);
    }



    public void delete(String userId)
    {
        userRepository.deleteById(userId);
    }
}
