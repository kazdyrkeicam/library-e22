package com.example.securityspringdemo.service;

import com.example.securityspringdemo.dao.BookRepo;
import com.example.securityspringdemo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return this.bookRepo.findAll();
    }

    public Optional<Book> getBookById(Long bookId) {
        return this.bookRepo.findById(bookId);
    }

    public void addBook(Book book) {
        this.bookRepo.save(book);
    }

    public void deleteBookById(Long bookId) {
        this.bookRepo.deleteById(bookId);
    }

    public void updateBook(Long bookId, Book book) throws IllegalStateException {
        Optional<Book> empty = Optional.empty();
//        if ( getBookById(bookId) == empty )
//            throw new IllegalStateException(String.format("Book of given id %d does not exists", bookId));
//        else {
//
//        }

        try {
            this.bookRepo.findById(bookId)
                    .map(book1 -> {
                        book1.setAuthor(book.getAuthor());
                        book1.setTitle(book.getTitle());
                        return this.bookRepo.save(book1);
                    })
                    .orElseThrow(() ->
                            new IllegalStateException(String.format("Book of given id %d does not exists", bookId))
                    );
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
