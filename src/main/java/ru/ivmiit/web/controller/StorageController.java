package ru.ivmiit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ivmiit.web.service.FileService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/file")
public class StorageController {

    @Autowired
    private FileService fileService;

    @GetMapping("/{id}")
    public void getFile(@PathVariable("id") Long fileId,
                        HttpServletResponse response){
        try {
            fileService.writeFileToResponse(fileId, response);
        } catch (IOException e) {
            throw new NotFoundException("File not found");
        }
    }

}
