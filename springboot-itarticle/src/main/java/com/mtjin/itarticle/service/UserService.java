package com.mtjin.itarticle.service;

import com.mtjin.itarticle.UserDto;
import com.mtjin.itarticle.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;

    @Transactional
    public Long saveUser(UserDto userDto){
        return userRepository.save(userDto.toEntity()).getId();
    }
}
