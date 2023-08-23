package com.hendisantika.springbootwkhtml2pdf.repository;

import com.hendisantika.springbootwkhtml2pdf.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-wkhtml2pdf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/23/23
 * Time: 12:35
 * To change this template use File | Settings | File Templates.
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
