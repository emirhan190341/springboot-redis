package com.emirhanarici.redis.controller;

import com.emirhanarici.redis.dto.CreateStudentDto;
import com.emirhanarici.redis.dto.UpdateStudentDto;
import com.emirhanarici.redis.model.Student;
import com.emirhanarici.redis.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@Slf4j
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody CreateStudentDto createStudentDto) {
        log.info("Student created");
        return ResponseEntity.ok(studentService.createStudent(createStudentDto));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudent() {
        log.info("Get all students");
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Student> getStudentById(@RequestParam Long id) {
        log.info("Get student by id: {}", id);
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody UpdateStudentDto dto) {
        log.info("Update student by id: {}", dto.getId());
        return new ResponseEntity<>(studentService.updateStudent(dto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        log.info("Delete student by id: {}", id);
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }


}
