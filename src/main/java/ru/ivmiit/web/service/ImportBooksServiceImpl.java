package ru.ivmiit.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivmiit.web.model.Book;
import ru.ivmiit.web.model.BookCategory;
import ru.ivmiit.web.model.Publisher;
import ru.ivmiit.web.repository.BookCategoryRepository;
import ru.ivmiit.web.repository.BookRepository;
import ru.ivmiit.web.repository.PublisherRepository;
import ru.ivmiit.web.transfer.BookDto;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImportBooksServiceImpl implements ImportBooksService {

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private FileService fileService;

    @Override
    @Transactional
    public List<Book> getBooksFrom(String path) throws IOException {
        File folder_main = new File(path);

        ArrayList<Book> books = new ArrayList<>();

        // По содержимому папки folder_main (DateBase_Books):
        for (File folder_genre : folder_main.listFiles()) {
            if(folder_genre.isDirectory()) // Папка "Жанр_i"
            {
                BookCategory category = createOrGetCategory(folder_genre.getName());
                // 1) Добавить эту категорию в БД (или проверять нет ли ее уже в БД).
                // 2) Получить ID этой категории, чтобы потом добавить его к book.categoryId

                // По содержимому папки "Жанр_i":
                for(File file_book : folder_genre.listFiles()){
                    if(file_book.isDirectory()) { // Папка "Книга_i"
                        Book book = new Book();
                        book.setCategory(category);
                        book.setRating((int) (Math.random() * 100));

                        // По содержимому папки "Книга_i":
                        for(File file : file_book.listFiles())
                        {
                            if(file.getName().equals("info.txt"))
                            {
                                // Считываем всю инфу про книгу
                                try{
                                    InputStream input = new FileInputStream(file);
                                    BufferedReader reader = new BufferedReader(new InputStreamReader(input, Charset.forName("Unicode")));
                                    String line;
                                    while((line = reader.readLine()) != null)
                                    {
                                        if(line.contains("Название"))
                                            book.setName(line.replace("Название : ", ""));
                                        else if(line.contains("Цена"))
                                            book.setPrice(Double.parseDouble(line
                                                    .replace("Цена : ", "")
                                                    .replace(" руб.", "")));
                                        else if(line.contains("ФИО автора"))
                                            book.setAuthor(line.replace("ФИО автора : ", ""));
                                        else if(line.contains("Количество страниц"))
                                            book.setPageCount( Integer.parseInt(line
                                                    .replace("Количество страниц : ", "")
                                                    .replace(" страниц", "")));
                                        else if(line.contains("Книг в наличии")) {
                                            String count_0 = line.replace("Книг в наличии : ", "");
                                            if(!count_0.equals("—"))
                                                book.setCount(Integer.parseInt(count_0));
                                        }
                                        else if(line.contains("Издательство"))
                                        {
                                            Publisher publisher = createOrGetPublisher(line.replace("Издательство : ", ""));
                                            book.setPublisher(publisher);
                                        }
                                        else if(line.contains("Аннотация"))
                                        { /* Само описание книги начинается со следующей строки*/
                                            if((line = reader.readLine()) != null)
                                                book.setDescription(line.substring(0, Math.min(1024, line.length())));
                                        }

                                    }
                                } catch (Exception e){
                                    System.out.println(e.toString());
                                }
                            }
                            else if(file.getName().equals("picture.jpg"))
                            {
                                // file.toString() - путь до изображения, начиная с папки folder_main
                                InputStream input = new FileInputStream(file);
                                ru.ivmiit.web.model.File title =  fileService.saveFile(input, file.getName(), file.getUsableSpace());
                                book.setTitlePage(title);
                            }
                        }
                        books.add(book); // Добавляем книгу в список
                    }
                }
            }
        }
        return books;
    }

    public BookCategory createOrGetCategory(String name){
        BookCategory bookCategory = bookCategoryRepository.findByNameContainingIgnoreCase("name").orElse(BookCategory.builder().name(name).build());
        bookCategoryRepository.save(bookCategory);
        return bookCategory;
    }

    public Publisher createOrGetPublisher(String name){
        Publisher publisher = publisherRepository.findByNameContainingIgnoreCase("name").orElse(Publisher.builder().name(name).build());
        publisherRepository.save(publisher);
        return publisher;
    }

    @Transactional
    @Override
    public void saveAllBooks(List<Book> books){
        bookRepository.saveAll(books);
    }

    @Override
    @Transactional
    public List<BookDto> importAllBooks(String path) throws IOException {
        List<Book> booksList = getBooksFrom(path);
        saveAllBooks(booksList);
        return booksList.stream().map(BookDto::from).collect(Collectors.toList());
    }
}
