package ru.ivmiit.web.service;

import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.ivmiit.web.model.File;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface FileService {
    File saveFile(MultipartFile file) throws IOException;

    @Transactional
    File saveFile(InputStream stream, String fileName, long size) throws IOException;

    void writeFileToResponse(Long id, HttpServletResponse response) throws IOException;

    void writeFileToResponse(File file, HttpServletResponse response) throws IOException;
}
