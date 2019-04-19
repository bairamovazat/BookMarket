package ru.ivmiit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.ivmiit.web.service.ImportBooksService;
import ru.ivmiit.web.transfer.BookDto;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/import")
public class ImportBooksController {

    @Autowired
    private ImportBooksService importBooksService;

    @GetMapping("/from")
    @ResponseBody
    public Object importBooksFrom(@RequestParam("path") String path) {
        try {
            List<BookDto> booksList = importBooksService.importAllBooks(path);
            return booksList;
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }
}
