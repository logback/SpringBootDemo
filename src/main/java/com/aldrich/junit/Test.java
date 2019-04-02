package com.aldrich.junit;

import com.aldrich.model.Student;
import com.aldrich.service.impl.StudentServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class Test {

   @Resource
   private StudentServiceImpl studentService;


    @org.junit.Test
    public void  test()
    {
        List<Student> list = studentService.searchStudents("大","数学",2);
        System.out.println(list);
    }

}
