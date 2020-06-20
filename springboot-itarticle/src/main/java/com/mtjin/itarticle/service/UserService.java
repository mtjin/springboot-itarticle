package com.mtjin.itarticle.service;

import com.mtjin.itarticle.UserDto;
import com.mtjin.itarticle.domain.entity.UserEntity;
import com.mtjin.itarticle.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;

    @Transactional
    public Long saveUser(UserDto userDto) {
        return userRepository.save(userDto.toEntity()).getId();
    }

    @Transactional
    public boolean isExistEmail(UserDto userDto) {
        return !userRepository.findUserEntityByEmail(userDto.toEntity().getEmail()).isEmpty();
    }

    @Transactional
    public boolean isExistName(UserDto userDto) {
        return !userRepository.findUserEntityByName(userDto.toEntity().getName()).isEmpty();
    }

    @Transactional
    public UserEntity login(UserDto userDto) {
        return userRepository.findUserEntityByEmailAndPassword(userDto.toEntity().getEmail(), userDto.toEntity().getPassword());
    }

}
