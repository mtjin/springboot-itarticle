package com.mtjin.itarticle;

import com.mtjin.itarticle.domain.entity.UserEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {
    private long id;
    private String name;
    private String email;
    private String password;

    public UserEntity toEntity() {
        UserEntity boardEntity = UserEntity.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .build();
        return boardEntity;
    }

    @Builder
    public UserDto(long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
