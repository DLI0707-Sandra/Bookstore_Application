package com.example.Bookstore.Repository;

import com.example.Bookstore.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
