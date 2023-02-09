package com.example.validate_form.service;

import com.example.validate_form.model.User;
import com.example.validate_form.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void add(User user);
}
