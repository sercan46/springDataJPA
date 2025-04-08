package com.sercanozbek.services;

import com.sercanozbek.dto.StudentDto;
import com.sercanozbek.dto.StudentUIDto;

import java.util.List;

public interface IStudentService {
    StudentDto saveStudent(StudentUIDto student);

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(int id);

    void deleteStudent(int id);

    StudentDto updateStudent(int id, StudentUIDto studentUIDto);
}
