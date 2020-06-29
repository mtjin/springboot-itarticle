package com.mtjin.itarticle;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AriticleDto {
    String imageUrl;
    String title;
    String content;
    String link;
}