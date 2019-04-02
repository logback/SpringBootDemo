package com.aldrich.service.impl;

import com.aldrich.mapper.StudentMapper;
import com.aldrich.model.Student;
import com.aldrich.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public List<Student> getStudents() {
        return studentMapper.getStudents();
    }

    @Override
    public List<Student> searchStudents(String name,String subject,int sort) {
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("subject",subject);
        String sorts = null;
        if(sort==0)
        {
            sorts="name";
        }
        if(sort==1)
        {
            sorts="subject";
        }
        if(sort==2)
        {
            sorts="score";
        }
        map.put("sort",sorts);
        return studentMapper.searchStudents(map);
    }


}
