package com.example.securityspringdemo.api;

import com.example.securityspringdemo.model.Book;
import com.example.securityspringdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("{bookId}")
    public Optional<Book> getBookById(@PathVariable("bookId") Long bookId) {
        return this.bookService.getBookById(bookId);
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
