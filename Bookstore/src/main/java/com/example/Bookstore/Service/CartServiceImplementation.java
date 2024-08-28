//package com.example.Bookstore.Service;
//
//import com.example.Bookstore.Model.Book;
//import com.example.Bookstore.Repository.BookRepository;
//import com.example.Bookstore.Repository.CartRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CartServiceImplementation implements CartService{
//
//    @Autowired
//    CartRepository cartRepository;
//
//    @Autowired
//    BookRepository bookRepository;
//
//    @Override
//    public void addItem(Long productId) {
//        Book book=bookRepository.findById(productId).orElse(null);
//
//    }
//}
