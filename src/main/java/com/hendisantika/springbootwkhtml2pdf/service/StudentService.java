package com.hendisantika.springbootwkhtml2pdf.service;

import com.hendisantika.springbootwkhtml2pdf.entity.Student;
import com.hendisantika.springbootwkhtml2pdf.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-wkhtml2pdf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/23/23
 * Time: 12:36
 * To change this template use File | Settings | File Templates.
 */
@Service("studentService")
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findOne(int id) {
        return studentRepository.getOne(id);
    }

    public List<Map<String, Object>> generateReports() {
        List<Map<String, Object>> result = new ArrayList<>();
        for (Student student : this.findAll()) {
            Map<String, Object> item = new HashMap<>();
            item.put("id", student.getId());
            item.put("name", student.getName());
            item.put("session", student.getSession());
            item.put("department", student.getDepartment());
            item.put("roll", student.getRoll());
            item.put("mobile", student.getMobile());
            result.add(item);
        }
        return result;
    }
}
