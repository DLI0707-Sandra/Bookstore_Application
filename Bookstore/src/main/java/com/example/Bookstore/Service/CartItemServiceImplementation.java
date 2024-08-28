package com.example.Bookstore.Service;

import com.example.Bookstore.Exception.OutOfStockException;
import com.example.Bookstore.Exception.ProductNotFoundException;
import com.example.Bookstore.Model.Book;
import com.example.Bookstore.Model.CartItem;
import com.example.Bookstore.Repository.BookRepository;
import com.example.Bookstore.Repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImplementation implements CartItemService{

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void addItem(Long productId) {
        Book book=bookRepository.findById(productId).orElse(null);

        if(book!=null)
        {
            if(book.getStock()==0)
            {
                throw new OutOfStockException();
            }
            else
            {
                CartItem cartItem=new CartItem();
                cartItem.setBook(book);
                cartItem.setQuantity(1);
                cartItemRepository.save(cartItem);
            }
        }
        else
            throw new ProductNotFoundException("Product not found!");
    }

    @Override
    public String  updateQuantity(Long cartitemId,int count) {
        CartItem cartItem=cartItemRepository.findById(cartitemId).orElse(null);
        if(cartItem!=null)
        {
            if(cartItem.getBook().getStock()>count)
            {
                cartItem.setQuantity(count);
                cartItemRepository.save(cartItem);
                return "Quantity updated successfully";
            }
            else
            {
                return "Not enough stock!";
            }
        }
        else
        {
            return "Cart item not found!";
        }

    }

    @Override
    public String deleteItem(Long id) {
        CartItem cartItem=cartItemRepository.findById(id).orElse(null);
        if(cartItem!=null)
        {
            cartItemRepository.deleteById(id);
            return "Deleted item from cart!";
        }
        else
            return "Cart item not found!";

    }

    @Override
    public List<CartItem> getAll() {
        return cartItemRepository.findAll();
    }
}
