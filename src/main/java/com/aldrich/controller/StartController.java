package com.aldrich.controller;

import com.aldrich.exception.MyException;
import com.aldrich.model.Student;
import com.aldrich.service.impl.StudentServiceImpl;
import com.aldrich.utils.ResponseUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Aldrich
 */

@Controller
@RequestMapping("/start")
public class StartController {


    @Resource
    private StudentServiceImpl studentService;

    /**
     * 返回首页
     * */
    @GetMapping(value = "/index")
    public ModelAndView viewPower()
    {
        return new ModelAndView("student");
    }


    /**
    * 返回所有学生
    * */
    @PostMapping(value = "/getStudents" ,produces = "application/json ;charset=UTF-8")
    public String getStudents(HttpServletResponse response)
    {
        List<Student> list = studentService.getStudents();
        String string = JSONObject.toJSONString(list);
        ResponseUtil.writeResp(response,string);
        return  null;
    }


    /**
     * 搜索返回所有学生
     * */
    @PostMapping(value = "/searchStudents" ,produces = "application/json ;charset=UTF-8")
    public String searchStudents(HttpServletResponse response,@RequestParam("name") String name,
                                                              @RequestParam("subject") String subject,
                                                              @RequestParam("sort") int sort) throws MyException
    {
         if("#".equals(name) ||"$".equals(name) ||"#".equals(subject) ||"$".equals(subject) ){
             throw new MyException("输入数据错误");
         }

        List<Student> list = studentService.searchStudents(name,subject,sort);
        String string = JSONObject.toJSONString(list);
        ResponseUtil.writeResp(response,string);
        return null;
    }

}
