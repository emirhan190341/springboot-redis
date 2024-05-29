package com.emirhanarici.redis.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateStudentDto {
    private Long id;
    private String name;
}
