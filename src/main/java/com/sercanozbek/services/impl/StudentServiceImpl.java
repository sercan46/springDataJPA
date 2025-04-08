package com.sercanozbek.services.impl;

import com.sercanozbek.dto.CourseDto;
import com.sercanozbek.dto.StudentDto;
import com.sercanozbek.dto.StudentUIDto;
import com.sercanozbek.entities.Student;
import com.sercanozbek.repository.StudentRepository;
import com.sercanozbek.services.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

    private final StudentRepository studentRepository;


    @Override
    public StudentDto saveStudent(StudentUIDto dtoStudentIU) {
        Student student = new Student();
        StudentDto response = new StudentDto();
        BeanUtils.copyProperties(dtoStudentIU, student);
        Student dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent, response);
        return response;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<StudentDto> dtoList = new ArrayList<>();
        List<Student> studentList = studentRepository.findAllStudents();
        for (Student student : studentList) {
            StudentDto dto = new StudentDto();
            BeanUtils.copyProperties(student, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public StudentDto getStudentById(int id) {
        return studentRepository.findById(id)
                .map(student -> {
                    StudentDto studentDto = new StudentDto();
                    BeanUtils.copyProperties(student, studentDto);
                    List<CourseDto> courseDtos = student.getCourses().stream()
                            .map(course -> {
                                CourseDto courseDto = new CourseDto();
                                BeanUtils.copyProperties(course, courseDto);
                                return courseDto;
                            })
                            .collect(Collectors.toList());
                    studentDto.setCourses(courseDtos);
                    return studentDto;
                })
                .orElse(null);

    }

    @Override
    public void deleteStudent(int id) {
        Optional<Student> optional = studentRepository.findById(id);
        if (optional != null) {
            studentRepository.delete(optional.get());
        }
    }

    @Override
    public StudentDto updateStudent(int id, StudentUIDto studentUIDto) {
        StudentDto dto = new StudentDto();
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            Student dbStudent = optional.get();
            dbStudent.setFirstName(studentUIDto.getFirstName());
            dbStudent.setLastName(studentUIDto.getLastName());
            dbStudent.setBirthOfDate(studentUIDto.getBirthOfDate());

            Student updatedStudent = studentRepository.save(dbStudent);
            BeanUtils.copyProperties(updatedStudent, dto);
            return dto;
        }
        return null;
    }
}
