package com.emirhanarici.redis.repository;

import com.emirhanarici.redis.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{
}
