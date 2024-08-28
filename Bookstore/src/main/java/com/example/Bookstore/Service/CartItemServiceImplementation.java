package com.example.Bookstore.Service;

import com.example.Bookstore.Exception.OutOfStockException;
import com.example.Bookstore.Exception.ProductNotFoundException;
import com.example.Bookstore.Model.Book;
import com.example.Bookstore.Model.Cart;
import com.example.Bookstore.Model.CartItem;
import com.example.Bookstore.Model.Users;
import com.example.Bookstore.Repository.BookRepository;
import com.example.Bookstore.Repository.CartItemRepository;
import com.example.Bookstore.Repository.CartRepository;
import com.example.Bookstore.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemServiceImplementation implements CartItemService{

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    UsersRepo usersRepo;

    @Override
    public void addItem(Long productId, Cart cart) {
        Book book=bookRepository.findById(productId).orElse(null);
        Cart cart1=cartRepository.findByUserId(cart.getUsers().getUserId()).orElse(null);
        if(cart1==null)
        {
            cart1=new Cart();
            Users users=usersRepo.findById(cart.getUsers().getUserId()).orElse(null);
            if(users!=null)
            {
                cart1.setUsers(cart.getUsers());
                cart1.setCreated_at(LocalDateTime.now());
                List<CartItem> items=new ArrayList<>();
                cartRepository.save(cart1);
                CartItem cartItem=new CartItem();
                cartItem.setBook(book);
                cartItem.setQuantity(1);
                cartItem.setCart(cart1);
                cartItemRepository.save(cartItem);

            }

        }
        else
        {
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
                    cartItem.setCart(cart);
                    cartItemRepository.save(cartItem);
                    List<CartItem>new_list=cart1.getCartItems();
                    new_list.add(cartItem);
                    cart1.setCartItems(new_list);
                    cartRepository.save(cart1);
                }
            }
            else
                throw new ProductNotFoundException("Product not found!");

        }

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
