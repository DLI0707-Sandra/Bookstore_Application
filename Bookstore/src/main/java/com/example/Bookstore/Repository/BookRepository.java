package com.example.Bookstore.Repository;

import com.example.Bookstore.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("SELECT b from Book b ORDER BY b.price ASC")
    List<Book> displayLowtoHigh();

    @Query("SELECT b from Book b ORDER BY b.price DESC")
    List<Book> displayHightoLow();

    @Query("SELECT b from Book b ORDER BY b.created_at DESC")
    List<Book> displayNewest();
}
