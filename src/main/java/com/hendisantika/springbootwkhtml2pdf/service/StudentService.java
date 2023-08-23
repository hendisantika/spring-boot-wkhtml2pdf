package com.hendisantika.springbootwkhtml2pdf.service;

import com.hendisantika.springbootwkhtml2pdf.entity.Student;
import com.hendisantika.springbootwkhtml2pdf.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
