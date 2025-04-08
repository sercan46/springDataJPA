package com.sercanozbek.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<CourseDto> courses = new ArrayList<>();
}
