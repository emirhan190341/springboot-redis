package com.emirhanarici.redis.service;

import com.emirhanarici.redis.dto.CreateStudentDto;
import com.emirhanarici.redis.dto.UpdateStudentDto;
import com.emirhanarici.redis.mapper.StudentMapper;
import com.emirhanarici.redis.model.Student;
import com.emirhanarici.redis.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @CacheEvict(value = {"students","student_id"}, allEntries = true)
    public Student createStudent(CreateStudentDto createStudentDto) {
        return studentRepository.save(StudentMapper.mapToStudent(createStudentDto));
    }

    @Cacheable(value = "students", key = "#root.methodName", unless = "#result == null")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Cacheable(cacheNames = "student_id", key = "#root.methodName + #id", unless = "#result == null")
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @CachePut(cacheNames = "student_id", key = "'getStudentById' + #dto.id", unless = "#result == null")
    public Student updateStudent(UpdateStudentDto dto) {
        Optional<Student> student = studentRepository.findById(dto.getId());
        if (student.isPresent()) {
            Student student1 = student.get();
            student1.setName(dto.getName());
            return studentRepository.save(student1);
        } else {
            return null;
        }
    }

    @CacheEvict(value = {"students", "student_id"}, allEntries = true)
    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "Student deleted";
    }

}
