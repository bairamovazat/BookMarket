package ru.ivmiit.web.service;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.ivmiit.web.model.File;
import ru.ivmiit.web.repository.FileRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Value("${storage.path}")
    private String storagePath;

    @Autowired
    private FileRepository fileRepository;

    @Override
    @Transactional
    public File saveFile(MultipartFile multipartFile) throws IOException {
        File file = File.builder()
                .fileName(multipartFile.getOriginalFilename())
                .size(multipartFile.getSize())
                .path(UUID.randomUUID())
                .build();
        java.io.File storageFile = new java.io.File(storagePath + "/" + file.getPath().toString());
        multipartFile.transferTo(storageFile);
        return fileRepository.save(file);
    }

    @Override
    public void writeFileToResponse(Long id, HttpServletResponse response) throws IOException {
        File file = fileRepository.findFirstById(id).orElseThrow(() -> new NotFoundException("File not found"));
        writeFileToResponse(file, response);
    }

    @Override
    public void writeFileToResponse(File file, HttpServletResponse response) throws IOException {
        response.setContentType(file.getType());
        InputStream inputStream = new FileInputStream(new java.io.File(storagePath + "/" + file.getPath().toString()));
        IOUtils.copy(inputStream, response.getOutputStream());
        response.flushBuffer();
    }

}
