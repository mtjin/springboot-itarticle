package com.mtjin.itarticle.domain.repository;

import com.mtjin.itarticle.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findUserEntityByEmail(String email);

    List<UserEntity> findUserEntityByName(String name);
}
