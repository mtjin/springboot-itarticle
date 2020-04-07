package com.mtjin.itarticle.domain.repository;

import com.mtjin.itarticle.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
