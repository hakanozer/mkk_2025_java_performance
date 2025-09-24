package com.example.services;

import com.example.entities.Book;
import com.example.repositories.BookRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    @Cacheable(value = "books", key = "#id")
    public Book findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @CacheEvict(value = "books", key = "#result.id", condition = "#result != null")
    public Book save(Book book) {
        return repository.save(book);
    }

    @CacheEvict(value = "books", key = "#id")
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
