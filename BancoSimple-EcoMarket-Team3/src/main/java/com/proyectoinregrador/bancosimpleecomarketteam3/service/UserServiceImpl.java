package com.proyectoinregrador.bancosimpleecomarketteam3.service;

import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;
import com.proyectoinregrador.bancosimpleecomarketteam3.model.User;
import com.proyectoinregrador.bancosimpleecomarketteam3.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User User) {
        return userRepository.save(User);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
