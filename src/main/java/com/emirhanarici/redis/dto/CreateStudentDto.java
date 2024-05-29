package com.emirhanarici.redis.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentDto {

    private String name;
    private Integer number;


}
