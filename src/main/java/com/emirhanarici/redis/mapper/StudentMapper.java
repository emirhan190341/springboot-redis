package com.emirhanarici.redis.mapper;

import com.emirhanarici.redis.dto.CreateStudentDto;
import com.emirhanarici.redis.dto.UpdateStudentDto;
import com.emirhanarici.redis.model.Student;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StudentMapper {

    public Student mapToStudent(CreateStudentDto createStudentDto) {

        return Student.builder()
                .name(createStudentDto.getName())
                .number(createStudentDto.getNumber())
                .build();
    }

    public Student mapToStudent(UpdateStudentDto updateStudentDto) {
        return Student.builder()
                .id(updateStudentDto.getId())
                .name(updateStudentDto.getName())
                .build();
    }
}
