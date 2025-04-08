package com.sercanozbek.controller.impl;

import com.sercanozbek.controller.IStudentController;
import com.sercanozbek.dto.StudentDto;
import com.sercanozbek.dto.StudentUIDto;
import com.sercanozbek.services.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/student")
@RequiredArgsConstructor
public class StudentControllerImpl implements IStudentController {

    private final IStudentService studentService;

    @PostMapping(path = "/save")
    @Override
    public StudentDto saveStudent(@RequestBody @Valid StudentUIDto studentUIDto) {
        return studentService.saveStudent(studentUIDto);
    }

    @GetMapping(path = "/list")
    @Override
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public StudentDto getStudentById(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
    }


    @PutMapping(path = "/update/{id}")
    @Override
    public StudentDto updateStudent(@PathVariable(name = "id") int id, @RequestBody StudentUIDto studentUIDto) {
        return studentService.updateStudent(id, studentUIDto);
    }
}
