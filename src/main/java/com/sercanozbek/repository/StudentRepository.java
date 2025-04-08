package com.sercanozbek.repository;

import com.sercanozbek.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "select * from student.student", nativeQuery = true)
    List<Student> findAllStudents();

    @Query(value = "select * from student.student where id=:studentId", nativeQuery = true)
    Optional<Student> findStudentById(int studentId);
}
