package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAllUser() {
        return List.of();
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }
}
