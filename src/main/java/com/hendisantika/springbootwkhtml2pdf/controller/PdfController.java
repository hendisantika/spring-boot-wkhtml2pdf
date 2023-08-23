package com.hendisantika.springbootwkhtml2pdf.controller;

import com.hendisantika.springbootwkhtml2pdf.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-wkhtml2pdf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/23/23
 * Time: 12:30
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequiredArgsConstructor
public class PdfController {

    private final StudentService studentService;

    @GetMapping("/pdf")
    public ResponseEntity<InputStreamResource> generatePdf() throws IOException {
        // 调用 wkhtmltopdf 命令将 HTML 转换成 PDF
        ProcessBuilder processBuilder = new ProcessBuilder("wkhtmltopdf", "http://localhost:8080/template.html", "-");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        // 从 Process 的输出流中获取 PDF 内容
        InputStreamResource inputStreamResource = new InputStreamResource(process.getInputStream());

        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "output.pdf");

        // 返回 ResponseEntity 包含 PDF 文件流和响应头
        return ResponseEntity.ok()
                .headers(headers)
                .body(inputStreamResource);
    }


    @GetMapping(value = "/report/html")
    public String getPdfReportForStudent(Model model) {
        model.addAttribute("studentList", studentService.findAll());
        return "sample2";
    }
}
