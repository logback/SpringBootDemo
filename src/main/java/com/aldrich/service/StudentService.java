package com.aldrich.service;

import com.aldrich.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<Student> getStudents();

    /**
     * @Author aldrich
     * @Description 的非官方的老公公
     * @Date 17:02 2019/3/24
     * @Param name subject sort
     * @return java.util.List<com.aldrich.model.Student>
     */
    List<Student>  searchStudents(String name,String subject,int sort);






}
