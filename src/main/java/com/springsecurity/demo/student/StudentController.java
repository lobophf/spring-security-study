package com.springsecurity.demo.student;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
  
  private static final List<Student> STUDENT = Arrays.asList(
      new Student(1L, "James Bond"),
      new Student(2L, "Maria Bond"),
      new Student(3L, "John Bond")
  );

  @GetMapping(path="{id}")
  public Student getStudent(@PathVariable("id") Long id){
    return STUDENT.stream().filter(student -> id.equals(student.getId())).findFirst().orElseThrow(() -> new IllegalStateException("Student " + id + " doesn't exists"));
  }

}
