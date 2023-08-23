package com.hendisantika.springbootwkhtml2pdf.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.net.MalformedURLException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-wkhtml2pdf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/23/23
 * Time: 12:37
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PdfDemo {

    public static final String DOWNLOAD_PATH = "tmp/downloads/";
    public static final String ZIP_PATH = "/tmp/zip_files";
    public static final String FILE_NAME = "student_list";
    public static final String SERVER_REPORT_URL = "/report/html";
    public static final String DOWNLOAD_FILE_PATH = DOWNLOAD_PATH + FILE_NAME;
    public static final String ZIPFILE = "/tmp/zip_files/cmed_report.zip";
    public static final String ZIPFILE_NAME = "cmed_report.zip";
    public static final String SRCDIR = "/tmp/downloads";
    public static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd-HH";
    @Value("${file.download.base}")
    private String DOWNLOAD_FOLDER;

    public static String getBaseURL() throws MalformedURLException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String baseUrl = "";
        if (request != null) {
            // handle proxy forward
            String scheme = request.getScheme();
            if (request.getHeader("x-forwarded-proto") != null) {
                scheme = request.getHeader("x-forwarded-proto");
            }

            Integer serverPort = request.getServerPort();
            if ((serverPort == 80) || (serverPort == 443)) {
                // No need to add the server port for standard HTTP and HTTPS ports, the scheme will help determine it.
                baseUrl = String.format("%s://%s%s", scheme, request.getServerName(), request.getContextPath());
            } else {
                baseUrl = String.format("%s://%s:%d%s", scheme, request.getServerName(), serverPort, request.getContextPath());
            }
        }

        return baseUrl;
    }
}
