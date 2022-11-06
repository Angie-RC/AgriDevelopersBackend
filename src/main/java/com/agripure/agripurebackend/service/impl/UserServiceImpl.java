package com.agripure.agripurebackend.service.impl;

import com.agripure.agripurebackend.entities.User;
import com.agripure.agripurebackend.repository.IUserRepository;
import com.agripure.agripurebackend.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User save(User user) throws Exception {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) throws Exception {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) throws Exception {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findByPremium(Boolean premium) throws Exception {
        return userRepository.findByPremium(premium);
    }
}