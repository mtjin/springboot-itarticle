package com.mtjin.itarticle;

import com.mtjin.itarticle.domain.entity.UserEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {
    private long id;
    private String email;
    private String password;

    public UserEntity toEntity() {
        UserEntity boardEntity = UserEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .build();
        return boardEntity;
    }

    @Builder
    public UserDto(long id, String email, String password, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
