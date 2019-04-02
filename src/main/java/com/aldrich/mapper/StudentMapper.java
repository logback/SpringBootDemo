package com.aldrich.mapper;

import com.aldrich.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    List<Student>  getStudents();

    List<Student>  searchStudents(Map map);

}
