package com.sercanozbek.controller;

import com.sercanozbek.dto.StudentDto;
import com.sercanozbek.dto.StudentUIDto;

import java.util.List;

public interface IStudentController {
    StudentDto saveStudent(StudentUIDto studentDtoUI);

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(int id);

    void deleteStudent(int id);

    StudentDto updateStudent(int id, StudentUIDto studentUIDto);
}
