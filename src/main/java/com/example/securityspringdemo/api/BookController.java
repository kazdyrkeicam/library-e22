package com.example.securityspringdemo.api;

import com.example.securityspringdemo.model.Book;
import com.example.securityspringdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
         return this.bookService.getAllBooks();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void addBook(@RequestBody Book book) {
        this.bookService.addBook(book);
    }

    @DeleteMapping(path = "{bookId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteBookById(@PathVariable("bookId") Long bookId) {
        this.bookService.deleteBookById(bookId);
    }

    @PutMapping(path = "{bookId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateBook(@PathVariable("bookId") Long bookId, @RequestBody Book book) {
        this.bookService.updateBook(bookId, book);
    }
}
